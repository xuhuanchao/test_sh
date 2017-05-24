package com.xhc.test.test_sh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xhc.test.test_sh.biz.IStudentBiz;
import com.xhc.test.test_sh.entity.Student;

@Repository
public class StudentDao extends BaseDao implements IStudentDao {

    
    
    public List<Student> getStudentByHql(String hql) {
        Query query = super.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Student> queryByName(String name) throws Exception {
        StringBuffer sb = new StringBuffer();
        Map<String, Object> p = new HashMap<String ,Object>();
        sb.append("from Student where name =:name");
        p.put("name", name);
        return super.queryByHql(sb.toString(), p);
    }
    

}
