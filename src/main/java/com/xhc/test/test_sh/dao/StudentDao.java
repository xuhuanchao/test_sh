package com.xhc.test.test_sh.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.xhc.test.test_sh.biz.IStudentBiz;
import com.xhc.test.test_sh.entity.Student;

public class StudentDao extends BaseDao implements IStudentBiz {

    
    public List<Student> getStudentByHql(String hql) {
        Query query = super.getSession().createQuery(hql);
        return query.list();
    }
    
    public List<Student> getStudents(List<Map<String, Object>> params) {
        
    }
}
