package wang.ismy.htmlcachesystem.service;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import wang.ismy.htmlcachesystem.dao.ConfigDao;
import wang.ismy.htmlcachesystem.dao.ItemDao;
import wang.ismy.htmlcachesystem.entity.Item;
import wang.ismy.htmlcachesystem.entity.ItemHtml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author MY
 * @date 2020/7/27 11:22
 */
@Service
public class ItemService {

    @Autowired
    FreeMarkerConfigurer configurer;

    @Autowired
    ItemDao itemDao;

    @Autowired
    ConfigDao configDao;

    @Value("${config.html-location}")
    String htmlLocation;

    public boolean generateHtml(Long id){
        try {
            Item item = itemDao.selectById(id);
            if (item == null){
                return false;
            }
            Template template = new Template("template",configDao.get("template"),configurer.getConfiguration());
            String s = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of("item",item));
            File file = new File(htmlLocation + id + ".html");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(s.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemHtml> generateAll() throws IOException {
        List<ItemHtml> items = itemDao.selectAllByItemHtml();
        Template template = new Template("template",configDao.get("template"),configurer.getConfiguration());
        for (ItemHtml item : items) {
            String location = htmlLocation + item.getId() + ".html";
            try(FileOutputStream fos = new FileOutputStream(location)){
                String s = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of("item",item));
                fos.write(s.getBytes());
                fos.flush();
                item.setStatus("success");
                item.setLocation(location);
            }catch (Exception e){
                item.setStatus("error:"+e.getMessage());
            }
        }
        return items;
    }

    @Transactional(rollbackFor = Exception.class)
    public int insert(Item item){
        try {
            int r = itemDao.insert(item);
            generateHtml(item.getId());
            return r;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }

    }

    public int update(Item item) {
        return itemDao.update(item);
    }
}
