package com.xhc.test.test_sh.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("indentity")
public class IdentityCtrl implements IIdentityCtrl {

    
    @RequestMapping("login") //用来处理前台的login请求  
    public @ResponseBody String hello(  
            @RequestParam(value = "username", required = false)String username,  
            @RequestParam(value = "password", required = false)String password  
            ){  
        return "Hello "+username+",Your password is: "+password;  
    } 
    
    @ResponseBody
    public String identity() {
        return "saf";
    }
}
