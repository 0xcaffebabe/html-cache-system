package wang.ismy.htmlcachesystem.service;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import wang.ismy.htmlcachesystem.dao.ItemDao;
import wang.ismy.htmlcachesystem.entity.Item;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Value("${config.html-location}")
    String htmlLocation;

    public boolean generateHtml(Long id){
        try {
            Item item = itemDao.selectById(id);
            if (item == null){
                return false;
            }
            Template template = configurer.getConfiguration().getTemplate("./item-template.ftl");
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
}
