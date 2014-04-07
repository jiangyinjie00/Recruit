package com.yzu.recruit.common.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseCriteria: entity criteria extends from it
 * 
 */
public abstract class Criteria {

    private String orderByClause;

    private SortMark sortMark;

    private boolean distinct;

    private List<Criterion> criterias = new ArrayList<Criterion>();

    public abstract void addCriterionEqual(String key, Object value);

    public abstract void addCriterionLike(String key, Object value);

    public abstract void addCriterionIn(String key, List<?> value);

    public abstract void addCriterionBetween(String key, Object value1,
            Object value2);
    
    public abstract void addCriterionGE(String key, Object value);
    
    public abstract void addCriterionLE(String key, Object value);
    
    public abstract void addCriterionNotEqual(String key, Object value);

    /**
     * Default methods for adding equal criterion.
     * 
     * @param conditionColumn
     *            the column used in sql.
     * @param value
     *            the value of search field.
     */
    public void addCriterion(String conditionColumn, Object value) {
        this.addCriterion(conditionColumn, null, value);
    }

    public void addCriterion(String conditionColumn, String conditionOperate,
            Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property
                    + " cannot be null");
        }
        this.addCriterion(conditionColumn, conditionOperate, value);
    }

    private void addCriterion(String conditionColumn, String conditionOperate,
            Object value) {
        if (conditionColumn == null) {
            throw new RuntimeException(
                    "Value for conditionColumn cannot be null");
        }
        if (conditionOperate == null) {
            conditionOperate = ConditionOperate.EQUAL;
        }
        criterias.add(new Criterion(conditionColumn, conditionOperate, value));
    }

    private void addCriterion(String conditionColumn, String operate,
            Object value1, Object value2) {
        if (conditionColumn == null) {
            throw new RuntimeException(
                    "Value for conditionColumn cannot be null");
        }
        criterias.add(new Criterion(conditionColumn, operate, value1, value2));
    }

    public void addCriterion(String conditionColumn, String operate,
            Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property
                    + " cannot be null");
        }
        this.addCriterion(conditionColumn, operate, value1, value2);
    }

    public void clear() {
        criterias.clear();
        orderByClause = null;
        distinct = false;
    }

    public boolean isValid() {
        return criterias.size() > 0;
    }

    // getter and setter
    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public SortMark getSortMark() {
        return sortMark;
    }

    public void setSortMark(SortMark sortMark) {
        this.sortMark = sortMark;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criterion> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<Criterion> criterias) {
        this.criterias = criterias;
    }

    /**
     * ConditionOperate: operate String
     * 
     */
    public static class ConditionOperate {
        public static final String EQUAL = "=";
        public static final String LIKE = "LIKE";
        public static final String IN = "IN";
        public static final String BETWEEN = "BETWEEN";
        public static final String IS = "IS";
        public static final String ISNOT = "IS NOT";
        public static final String GE = ">=";
        public static final String LE = "<=";
        public static final String NOT_EQUAL = "!=";
        public static final String IS_NULL = "IS NULL";
    }

    /**
     * SortMark: enum
     * 
     */
    public enum SortMark {
        DESC, ASC;
    }
}
