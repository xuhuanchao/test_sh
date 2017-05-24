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
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao implements IBaseDao {
    
    @Autowired
    @Qualifier("hibernateTemplate")
    HibernateTemplate hibernateTemplate;
    
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Qualifier("simpleJdbcCall")
    SimpleJdbcCall simpleJdbcCall;
    
    @Autowired
    @Qualifier("simpleJdbcInsert")
    SimpleJdbcInsert simpleJdbcInsert;
    
    
    public Session getSession(){
        return hibernateTemplate.getSessionFactory().openSession();
    }

    @Override
    public List queryByHql(String hql, Map<String, Object> params)  throws Exception {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setProperties(params);
        List list = query.list();
        session.close();
        return list;
    }

    
    @Override
    public List queryBySql(String sql, Map<String, Object> params) throws Exception {
        SQLQuery sqlQuery = getSession().createSQLQuery(sql);
        sqlQuery.setProperties(params);
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
