package com.xhc.test.test_sh.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

import com.xhc.test.test_sh.entity.Student;

@Repository
public class BaseDao<T> implements IBaseDao<T> {
    
    @Autowired
    @Qualifier("hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Qualifier("simpleJdbcCall")
    private SimpleJdbcCall simpleJdbcCall;
    
    @Autowired
    @Qualifier("simpleJdbcInsert")
    private SimpleJdbcInsert simpleJdbcInsert;
    
    
    public Session getSession(){
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    private Class<T> getImplTClass () {
        Type type = this.getClass().getGenericSuperclass();
        if(type instanceof ParameterizedType){
            Class<T> clazz = (Class<T>)((ParameterizedType) type).getActualTypeArguments()[0];
            return clazz;
        }else{
            return null;
        }
    }
    
    
    @Override
    public List<T> queryByHql(String hql, Map<String, Object> params)  throws Exception {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setProperties(params);
        List list = query.list();
        session.close();
        return list;
    }

    
    @Override
    public List<T> queryBySql(String sql, Map<String, Object> params) throws Exception {
        SQLQuery sqlQuery = getSession().createSQLQuery(sql);
        sqlQuery.setProperties(params);
        return sqlQuery.list();
    }


    @SuppressWarnings("unchecked")
    @Override
    public T getEntityById(String id) throws Exception {
        Class<T> clazz = getImplTClass();
        if(clazz != null){
            return hibernateTemplate.get(clazz, id);    
        }else{
            return null;
        }
    }

    @Override
    public List<T> queryByQueryInfo (QueryInfo queryInfo) throws Exception {
        List<Object> values = new ArrayList<Object>();
        Map<String, SqlConditionsEnum> paramConditions = queryInfo.getParamConditions();
        StringBuffer sb = new StringBuffer();
        sb.append(" FROM " + getImplTClass().getSimpleName() + " WHERE 1=1 ");
        Iterator<Entry<String, Object>> iterator = queryInfo.getParamValues().entrySet().iterator();

        while(iterator.hasNext()){
            Entry<String, Object> param = iterator.next();
            String key = param.getKey();
            Object value = param.getValue();
            SqlConditionsEnum condition = paramConditions.get(key);
            if(value != null && !"".equals(value)){
                if(condition.equals(SqlConditionsEnum.EQ) || condition.equals(SqlConditionsEnum.LT) || 
                        condition.equals(SqlConditionsEnum.RT) ){
                    sb.append(" AND " + key + " " + condition.getValue() + " ? " );
                    values.add(value);
                } else if( condition.equals(SqlConditionsEnum.LIKE)){
                    sb.append(" AND " + key + " " + condition.getValue() + " ? " );
                    values.add("%" + value + "%");
                }
            }
        }
        if(values.size() > 0){
            return (List<T>)hibernateTemplate.find(sb.toString(), values.toArray());            
        }else{
            return (List<T>)hibernateTemplate.find(sb.toString());
        }

    }
    
    
    @Override
    public void delete(T entity) throws Exception {
        hibernateTemplate.delete(entity);
        
    }

    @Override
    public void add(T entity) throws Exception {
        hibernateTemplate.save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        hibernateTemplate.saveOrUpdate(entity);
    }

    
    
    /** getter setter **/
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public SimpleJdbcCall getSimpleJdbcCall() {
        return simpleJdbcCall;
    }

    public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
        this.simpleJdbcCall = simpleJdbcCall;
    }

    public SimpleJdbcInsert getSimpleJdbcInsert() {
        return simpleJdbcInsert;
    }

    public void setSimpleJdbcInsert(SimpleJdbcInsert simpleJdbcInsert) {
        this.simpleJdbcInsert = simpleJdbcInsert;
    }
    
    
    
    
}
