package com.xhc.test.test_sh.biz;

import java.util.List;
import java.util.Map;

import com.xhc.test.test_sh.entity.Student;

public interface IStudentBiz {

    
    public List<Student> queryByName(String name) throws Exception;
    
    public List<Student> queryStudent(Map<String, Object> params) throws Exception;
}
