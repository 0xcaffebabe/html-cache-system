package wang.ismy.htmlcachesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.htmlcachesystem.dao.ConfigDao;
import wang.ismy.htmlcachesystem.dao.ItemDao;
import wang.ismy.htmlcachesystem.entity.Item;
import wang.ismy.htmlcachesystem.service.ItemService;

/**
 * @author MY
 * @date 2020/7/23 13:59
 */
@RestController
@Slf4j
public class Api {

    @Autowired
    ItemDao itemDao;

    @Autowired
    ItemService itemService;

    @Autowired
    ConfigDao configDao;

    /**
     * 后台接收添加item请求接口
     * @param item
     * @return
     */
    @PostMapping("item")
    public String addItem(@RequestBody Item item){
        log.info(item.toString());
        if (itemDao.insert(item) == 1){
            return item.getId().toString();
        }
        return "error";
    }

    @PostMapping("generate/{id}")
    public String generate(@PathVariable Long id){
        if (itemService.generateHtml(id)){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("template")
    public String getTemplate(){
        return configDao.get("template");
    }

    @PutMapping("template")
    public String updateTemplate(@RequestBody String template){
        if (configDao.set("template",template) == 1){
            return "success";
        }else {
            return "error";
        }
    }
}
