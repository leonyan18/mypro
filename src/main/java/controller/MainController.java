package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yan
 * @date 2018/9/11 19:14
 * @descripition 主页面控制
 */
@Controller
@RequestMapping(value = "/user")
public class MainController {
    @RequestMapping(value = "/{username}",method =RequestMethod.GET)
    public String main(@PathVariable String username, Model model){
        if(!model.containsAttribute("username")){
            /**数据库查询*/
        }
        return "user";
    }
}
