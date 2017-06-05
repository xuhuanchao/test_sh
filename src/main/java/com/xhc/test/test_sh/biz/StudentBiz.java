package com.xhc.test.test_sh.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.xhc.test.test_sh.dao.IStudentDao;
import com.xhc.test.test_sh.entity.Student;

@Service
public class StudentBiz implements IStudentBiz {

    @Autowired
    @Qualifier("studentDao")
    IStudentDao studentDao;

    @Override
    public List<Student> queryByName(String name) throws Exception {
        return studentDao.queryByName(name);
    }

    @Override
    public List<Student> queryStudent(Map<String, Object> params) throws Exception {
        return studentDao.queryStuden(params);
    }
    
    @Override
    
    public void addStudent(Student student) throws Exception {
        studentDao.addStudent(student);
        throw new Exception("aaaa");
    }
}
