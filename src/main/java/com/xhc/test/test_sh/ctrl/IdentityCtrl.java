package com.xhc.test.test_sh.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IdentityCtrl implements IIdentityCtrl {

    
    @RequestMapping("indentity/login") //用来处理前台的login请求  
    @ResponseBody
    @Override
    public String hello(  
            @RequestParam(value = "username", required = false)String username,  
            @RequestParam(value = "password", required = false)String password  
            ){  
        return "Hello "+username+",Your password is: "+password;  
    } 
    
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("student");
        return modelAndView;
    }
}
