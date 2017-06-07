package com.xhc.test.test_sh.base;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {

    
    public List<T> queryByHql(String hql, Map<String, Object> params) throws Exception;
    
    public List<T> queryBySql(String sql, Map<String, Object> params) throws Exception;
    
    public T getEntityById(String id) throws Exception;
    
    public List<T> queryByQueryInfo (QueryInfo queryInfo) throws Exception;
    
    public void add(T entity) throws Exception;
    
    public void saveOrUpdate(T entity) throws Exception;
    
    public void delete(T entity) throws Exception;
    
}
