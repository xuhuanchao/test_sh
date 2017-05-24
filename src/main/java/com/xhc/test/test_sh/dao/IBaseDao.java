package com.xhc.test.test_sh.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {

    
    public List queryByHql(String hql, Map<String, Object> params) throws Exception;
    
    public List queryBySql(String sql, Map<String, Object> params) throws Exception;
    
    public void add(Map<String, Object> entity) throws Exception;
    
    public void saveOrUpdate(Map<String, Object> entity) throws Exception;
    
    public void delete(Map<String, Object> entity) throws Exception;
    
}
