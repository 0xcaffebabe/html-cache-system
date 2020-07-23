package wang.ismy.htmlcachesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.htmlcachesystem.dao.ItemDao;

/**
 * @author MY
 * @date 2020/7/23 13:04
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("hi")
    public String hello(){
        log.info(itemDao.selectAll().toString());
        return "hello world";
    }
}
