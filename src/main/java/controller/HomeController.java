package controller;

import org.springframework.stereotype.Controller;
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
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(){
        return "redirect:/pizza";
    }
}
