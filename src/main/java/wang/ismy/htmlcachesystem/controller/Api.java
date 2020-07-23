package wang.ismy.htmlcachesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.htmlcachesystem.dao.ItemDao;
import wang.ismy.htmlcachesystem.entity.Item;

/**
 * @author MY
 * @date 2020/7/23 13:59
 */
@RestController
@Slf4j
public class Api {

    @Autowired
    ItemDao itemDao;

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
}
