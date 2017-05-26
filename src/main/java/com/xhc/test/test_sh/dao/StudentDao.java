package com.xhc.test.test_sh.dao;

import java.util.ArrayList;
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

    
    @Override
    public List<Student> queryStuden(Map<String, Object> params) throws Exception {
        List names = new ArrayList();
        List values = new ArrayList();
        StringBuffer sb = new StringBuffer();
        sb.append("from Student where 1=1 ");
        if(!StringUtils.isEmpty(params.get("name"))){
            sb.append(" and name like '%"+params.get("name")+"%'");
        }
        if(!StringUtils.isEmpty(params.get("age"))){
            sb.append(" and age = "+params.get("age"));
        }
        if(!StringUtils.isEmpty(params.get("address"))){
            sb.append(" and address like '%"+params.get("address") + "%'");
        }
        if(!StringUtils.isEmpty(params.get("hobby"))){
            sb.append(" and hobby like '%"+params.get("hobby") + "%'");
        }
        if(!StringUtils.isEmpty(params.get("classname"))){
            sb.append(" and hobby classname '%"+params.get("classname") + "%'");
        }
        return (List<Student>)hibernateTemplate.find(sb.toString());
    }
    

}
