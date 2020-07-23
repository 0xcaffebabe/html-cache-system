package wang.ismy.htmlcachesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MY
 * @date 2020/7/23 13:06
 */
@Controller
public class PageController {
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }

    @GetMapping("/add")
    public String add(){
        return "redirect:/add.html";
    }
}
