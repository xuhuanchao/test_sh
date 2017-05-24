package com.xhc.test.test_sh.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    
    
}
