package controller;

import dao.UserDao;
import dao.UserDaoByEm;
import dao.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
    @Qualifier("userDaoByEm")
    UserDao userDao;
    @RequestMapping(value = "",method = RequestMethod.GET)
    @Transactional(rollbackFor = Exception.class)
    public String home(Model model){
        model.addAttribute("test",userDao.findByUsername("yan"));
        return "home";
    }
}
