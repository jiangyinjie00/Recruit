package com.yzu.recruit.common.pagination;

import java.util.List;

/**
 * Criterion: search condition of criteria
 * 
 */
public class Criterion {
    private String conditionColumn;

    private String operate;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getConditionColumn() {
        return conditionColumn;
    }

    public String getOperate() {
        return operate;
    }

    public Object getValue() {
        return value;
    }

    public Object getSecondValue() {
        return secondValue;
    }

    public boolean isNoValue() {
        return noValue;
    }

    public boolean isSingleValue() {
        return singleValue;
    }

    public boolean isBetweenValue() {
        return betweenValue;
    }

    public boolean isListValue() {
        return listValue;
    }

    public String getTypeHandler() {
        return typeHandler;
    }

    public Criterion(String conditionColumn, String opreate, Object value,
            String typeHandler) {
        super();
        this.conditionColumn = conditionColumn;
        this.operate = opreate;
        this.value = value;
        this.typeHandler = typeHandler;
        if (value instanceof List<?>) {
            this.listValue = true;
        } else {
            this.singleValue = true;
        }
    }

    public Criterion(String conditionColumn, String operate, Object value) {
        this(conditionColumn, operate, value, null);
    }

    public Criterion(String conditionColumn, String opreate, Object value,
            Object secondValue, String typeHandler) {
        super();
        this.conditionColumn = conditionColumn;
        this.operate = opreate;
        this.value = value;
        this.secondValue = secondValue;
        this.typeHandler = typeHandler;
        this.betweenValue = true;
    }

    public Criterion(String conditionColumn, String opreate, Object value,
            Object secondValue) {
        this(conditionColumn, opreate, value, secondValue, null);
    }
    
    public Criterion(String conditionColumn, String opreate) {
        this.conditionColumn = conditionColumn;
        this.operate = opreate;
        this.noValue = true;
    }

}
