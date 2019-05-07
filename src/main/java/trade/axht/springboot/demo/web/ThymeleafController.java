package trade.axht.springboot.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import trade.axht.springboot.demo.exception.entity.MyException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {
    @RequestMapping("/")
    public String index(HttpServletRequest request,ModelMap map){
        map.addAttribute("host",request.getRequestURL().toString());
        return "/index";
    }
    @RequestMapping("/exception")
    public String throwException() throws Exception {
        throw new Exception();
    }
    @RequestMapping("/jsonError")
    public String jsonErrorException() throws MyException {
        throw new ArithmeticException("错误信息");
    }

    @RequestMapping("/helloT")
    public String helloT(){
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
