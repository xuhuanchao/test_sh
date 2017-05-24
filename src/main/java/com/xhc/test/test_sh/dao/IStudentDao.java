package com.xhc.test.test_sh.dao;

import java.util.List;
import java.util.Map;

import com.xhc.test.test_sh.entity.Student;

public interface IStudentDao {
    
    public List<Student> queryByName(String name) throws Exception;
}
