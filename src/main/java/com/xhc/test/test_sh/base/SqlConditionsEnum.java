package com.xhc.test.test_sh.base;

public enum SqlConditionsEnum {
    
    LT("<"),
    RT(">"),
    EQ("="),
    NQ("!="),
    LIKE("like"),
    ISNULL("is null"),
    NOTNULL("is not null"),
    IN("in"),
    BETWEEN("between");
    
    private String value;
    private SqlConditionsEnum(String name) {
        this.value = name;
    }
    
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    
}
