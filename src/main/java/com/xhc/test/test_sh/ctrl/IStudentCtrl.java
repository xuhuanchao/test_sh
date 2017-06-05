package com.xhc.test.test_sh.ctrl;

import java.util.Map;


import com.xhc.test.test_sh.entity.Student;

public interface IStudentCtrl {
    
    public String queryByName(String name) throws Exception;
    
    public Map queryStudent(Map<String, Object> params ) throws Exception;
    
    public Map<String, Object> addStudent(Student student) throws Exception;
}
