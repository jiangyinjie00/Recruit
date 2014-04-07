package com.yzu.recruit.common.pagination;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implements some basic function for criteria.
 *
 */
public abstract class BaseCriteria extends Criteria {

    protected abstract String getMapValue(String columnKey);

    @Override
    public void addCriterionEqual(String key, Object value) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.EQUAL, value, key);
    }

    @Override
    public void addCriterionLike(String key, Object value) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.LIKE, "%" + value
                + "%", key);
    }

    @Override
    public void addCriterionIn(String key, List<?> value) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.IN, value, key);
    }

    @Override
    public void addCriterionBetween(String key, Object value1, Object value2) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.BETWEEN, value1,
                value2, key);
    }

    @Override
    public void addCriterionGE(String key, Object value) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.GE, value, key);
    }

    @Override
    public void addCriterionLE(String key, Object value) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.LE, value, key);
    }

    @Override
    public void addCriterionNotEqual(String key, Object value) {
        String conditionColumn = this.getMapValue(key);
        this.addCriterion(conditionColumn, ConditionOperate.NOT_EQUAL, value,
                key);
    }

    /**
     * Basic convert to parses map and sets criteria.
     * @param baseCriteria
     * @param criteria
     */
    public void convertCriteria(BaseCriteria baseCriteria,
            CriteriaMap criteria) {
        Map<String, String> equalMap = null;
        Map<String, String> likeMap = null;
        Map<String, List<String>> inMap = null;
        Map<String, BetweenValueObject> betweenMap = null;

        if (null != criteria) {
            equalMap = criteria.getEqualMap();
            likeMap = criteria.getLikeMap();
            inMap = criteria.getInMap();
            betweenMap = criteria.getBetweenMap();

            // Set sort
            if (null != criteria.getOrderByClause()
                    && !"".equals(criteria.getOrderByClause())) {
                baseCriteria.setOrderByClause(getMapValue(criteria
                        .getOrderByClause()));
                baseCriteria.setSortMark(SortMark.valueOf(criteria
                        .getSortMark().name()));
            }
        }

        // Iterates equalMap, and addCriterionEqual
        if (null != equalMap) {
            Set<Map.Entry<String, String>> equalSet = equalMap.entrySet();
            Iterator<Map.Entry<String, String>> equalIt = equalSet.iterator();
            while (equalIt.hasNext()) {
                Map.Entry<String, String> entry = equalIt.next();
                if (null != entry.getValue() && !"".equals(entry.getValue())) {
                    baseCriteria.addCriterionEqual(entry.getKey(),
                            entry.getValue());
                }
            }
        }

        // Iterates likeMap, and addCriterionLike
        if (null != likeMap) {
            Set<Map.Entry<String, String>> likeSet = likeMap.entrySet();
            Iterator<Map.Entry<String, String>> likeIt = likeSet.iterator();
            while (likeIt.hasNext()) {
                Map.Entry<String, String> entry = likeIt.next();
                if (null != entry.getValue() && !"".equals(entry.getValue())) {
                    baseCriteria.addCriterionLike(entry.getKey(),
                            entry.getValue());
                }
            }
        }

        // Iterates inMap, and addCriterionIn
        if (null != inMap) {
            Set<Map.Entry<String, List<String>>> inSet = inMap.entrySet();
            Iterator<Map.Entry<String, List<String>>> inIt = inSet.iterator();
            while (inIt.hasNext()) {
                Map.Entry<String, List<String>> entry = inIt.next();
                // Judge Status
                if (null != entry.getValue() && entry.getValue().size() != 0) {
                    baseCriteria.addCriterionIn(entry.getKey(),
                            entry.getValue());
                }
            }
        }

        // Iterates betweenMap, and addCriterionBetween
        if (null != betweenMap) {
            Set<Map.Entry<String, BetweenValueObject>> betweenSet = betweenMap
                    .entrySet();
            Iterator<Map.Entry<String, BetweenValueObject>> betweenIt = betweenSet
                    .iterator();
            while (betweenIt.hasNext()) {
                Map.Entry<String, BetweenValueObject> entry = betweenIt.next();
                if (null != entry.getValue()) {
                    if (null != entry.getValue().getFirstValue()
                            && !"".equals(entry.getValue().getFirstValue())) {
                        baseCriteria.addCriterionGE(entry.getKey(), entry
                                .getValue().getFirstValue());
                    }
                    if (null != entry.getValue().getSecondValue()
                            && !"".equals(entry.getValue().getSecondValue())) {
                        baseCriteria.addCriterionLE(entry.getKey(), entry
                                .getValue().getSecondValue());
                    }
                }
            }
        }
    }
}
