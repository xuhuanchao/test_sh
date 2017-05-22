package com.xhc.test.test_sh.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {

    
    public List<Map<String, Object>> queryByHql(String hql) throws Exception;
    
    public List<Map<String, Object>> queryBySql(String sql) throws Exception;
    
    public void add(Map<String, Object> entity) throws Exception;
    
    public void saveOrUpdate(Map<String, Object> entity) throws Exception;
    
    public void delete(Map<String, Object> entity) throws Exception;
    
}
