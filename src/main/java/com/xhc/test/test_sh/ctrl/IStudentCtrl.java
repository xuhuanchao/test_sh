package com.xhc.test.test_sh.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.xhc.test.test_sh.entity.Student;

public interface IStudentCtrl {
    
    public String queryByName(String name) throws Exception;
    
    public Map queryStudent(Map<String, Object> params ) throws Exception;
}
