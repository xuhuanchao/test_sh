package com.xhc.test.test_sh.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.xhc.test.test_sh.dao.StudentDao;
import com.xhc.test.test_sh.entity.Student;

public class QueryInfo {

    private Map<String, SqlConditionsEnum> paramConditions = new HashMap<String, SqlConditionsEnum>();
    
    private Map<String, Object> paramValues = new HashMap<String, Object>();

    public QueryInfo() {
        super();
    }
    
    
    
    public QueryInfo( Map<String, SqlConditionsEnum> paramConditions, Map<String, Object> paramValues) {
        super();
        this.paramConditions = paramConditions;
        this.paramValues = paramValues;
    }


    public Map<String, SqlConditionsEnum> getParamConditions() {
        return paramConditions;
    }

    public void setParamConditions(Map<String, SqlConditionsEnum> paramConditions) {
        this.paramConditions = paramConditions;
    }

    public Map<String, Object> getParamValues() {
        return paramValues;
    }

    public void setParamValues(Map<String, Object> paramValues) {
        this.paramValues = paramValues;
    }
    
    

}
