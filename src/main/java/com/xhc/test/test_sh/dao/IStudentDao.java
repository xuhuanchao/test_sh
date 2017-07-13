package com.xhc.test.test_sh.dao;

import java.util.List;
import java.util.Map;

import com.xhc.test.test_sh.base.IBaseDao;
import com.xhc.test.test_sh.base.QueryInfo;
import com.xhc.test.test_sh.entity.Student;

public interface IStudentDao extends IBaseDao<Student> {
    
    public List<Student> queryByName(String name) throws Exception;
    
    public List<Student> queryStudent(Map<String, Object> params) throws Exception;
    
    public List<Student> queryStudent(QueryInfo queryInfo) throws Exception;
    
    public void addStudent(Student student) throws Exception ;
    
    public Student updateStudent(Student student) throws Exception;
}
