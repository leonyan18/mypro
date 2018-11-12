package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.util.List;

/**
 * @author yan
 * @date 2018/9/9 14:36
 * @descripition 主页控制
 */
@Controller
public class HomeController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(Model model){
        return "home";
//        return "redirect:/pizza";//webflow
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public User test(){
        User user=new User();
        user.setUsername("yan");
        return user;
    }
}
