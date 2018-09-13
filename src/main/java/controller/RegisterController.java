package controller;

import bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * @author yan
 * @date 2018/9/9 15:52
 * @descripition 注册控制
 */
@Controller
public class RegisterController {
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model)
    {
        model.addAttribute("people",new People());
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST )
    public String processRegister(@Valid People people, Errors errors,RedirectAttributes model) throws UnsupportedEncodingException {
        people.setName(new String(people.getName().getBytes ( "ISO8859-1" ), "utf-8"));
        if(errors.hasErrors()){
            System.out.println("ERROR");
            System.out.println(errors.getFieldError().getDefaultMessage());
            return "register";
        }
        model.addAttribute("username",people.getName());
        /**没有被使用就被当作url的参数传递*/
        model.addAttribute("name",people.getName());
        /**存到会话中*/
        model.addFlashAttribute(people);
        /**重定向*/
        return "redirect:/user/{username}";
    }
}
