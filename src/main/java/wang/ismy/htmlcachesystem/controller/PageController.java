package wang.ismy.htmlcachesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import wang.ismy.htmlcachesystem.dao.ItemDao;
import wang.ismy.htmlcachesystem.entity.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author MY
 * @date 2020/7/23 13:06
 */
@Controller
public class PageController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }

    @GetMapping("/add")
    public String add(){
        return "redirect:/add.html";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap){
        List<Item> items = itemDao.selectAll();
        modelMap.addAttribute("items",items);
        return "list";
    }

    @GetMapping("editTemplate")
    public String editTemplatePage(){
        return "edit-template";
    }
}
