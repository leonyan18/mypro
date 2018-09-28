package controller;

import dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yan
 * @date 2018/9/9 14:36
 * @descripition 主页控制
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("test",userRepository.findByUsernameOrderByUidAsc("yan"));
        return "home";
    }
}
