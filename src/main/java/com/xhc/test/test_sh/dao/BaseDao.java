package com.xhc.test.test_sh.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseDao implements IBaseDao {
    
    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    SimpleJdbcCall simpleJdbcCall;
    
    @Autowired
    SimpleJdbcInsert simpleJdbcInsert;
    
    
    public Session getSession(){
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    @Override
    public List<Map<String, Object>> queryByHql(String hql)  throws Exception {
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    
    @Override
    public List<Map<String, Object>> queryBySql(String sql) throws Exception {
        SQLQuery sqlQuery = getSession().createSQLQuery(sql);
        return sqlQuery.list();
    }

    @Override
    public void add(Map<String, Object> entity) throws Exception {
        hibernateTemplate.save(entity);
    }

    @Override
    public void saveOrUpdate(Map<String, Object> entity) throws Exception {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    public void delete(Map<String, Object> entity) throws Exception {
        hibernateTemplate.delete(entity);
    }
    
    
    
    
}
