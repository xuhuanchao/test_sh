package com.xhc.test.test_sh.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xhc.test.test_sh.base.QueryInfo;
import com.xhc.test.test_sh.base.SqlConditionsEnum;
import com.xhc.test.test_sh.dao.IStudentDao;
import com.xhc.test.test_sh.entity.Student;

@Service
public class StudentBiz implements IStudentBiz {

    @Autowired
    @Qualifier("studentDao")
    IStudentDao studentDao;

    @Override
    @Cacheable(value="student", key="#name")
    @Transactional
    public List<Student> queryByName(String name) throws Exception {
        return studentDao.queryByName(name);
    }

    @Override
    @Cacheable(value="student" ,key="#params.get('name').concat(#params.get('age'))")
    public List<Student> queryStudent(Map<String, Object> params) throws Exception {
        QueryInfo queryInfo = new QueryInfo();
        Map<String, SqlConditionsEnum> paramConditions = new HashMap<String, SqlConditionsEnum>();
        paramConditions.put("name", SqlConditionsEnum.LIKE);
        paramConditions.put("age", SqlConditionsEnum.EQ);
        paramConditions.put("address", SqlConditionsEnum.LIKE);
        paramConditions.put("hobby", SqlConditionsEnum.LIKE);
        paramConditions.put("classname", SqlConditionsEnum.LIKE);
        queryInfo.setParamConditions(paramConditions);
        if(!StringUtils.isEmpty(params.get("age"))){
            params.put("age", Integer.parseInt((params.get("age").toString())));    
        }
        queryInfo.setParamValues(params);
        return studentDao.queryStudent(queryInfo);
    }
    
    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.addStudent(student);
    }

    @Override
    @CachePut(value="student", key="#student.getName().concat(#student.getId())")
    public Student updateStudent(Student student) throws Exception {
        return studentDao.updateStudent(student);
    }

    @Override
    @CacheEvict(value="student", allEntries=true)
    public void clearCache() throws Exception {
        
    }
    
    
    
}
