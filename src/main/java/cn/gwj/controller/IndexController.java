package cn.gwj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

//    @Override
//    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        return new ModelAndView("login");
//    }

//    @RequestMapping("/in.html")
//    public String index(){
//        return  "login" ;
//    }

    @RequestMapping(value = "add.html",method = RequestMethod.GET,params = "userName")
    public String add(String userName){
        System.out.println("接收到传递来的参数"+userName);
        return "login";
    }

}
