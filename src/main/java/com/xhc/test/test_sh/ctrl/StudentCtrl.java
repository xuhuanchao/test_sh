package com.xhc.test.test_sh.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xhc.test.test_sh.biz.IStudentBiz;
import com.xhc.test.test_sh.entity.Student;

import net.sf.json.JSONArray;

@Controller 
@RequestMapping("student")
public class StudentCtrl implements IStudentCtrl {

    @Autowired
    @Qualifier("studentBiz")
    IStudentBiz studentBiz;
    
    @Override
    @ResponseBody
    @RequestMapping(value="queryByName" , produces = "application/json; charset=UTF-8")//
    public String queryByName(@RequestParam(value="name" )String name) throws Exception {
        List list = studentBiz.queryByName(name);
        return JSONArray.fromObject(list).toString();
    }

    
    

    
    
}
