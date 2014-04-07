package com.yzu.recruit.common.pagination;

import java.util.List;
import java.util.Map;

public class CriteriaMap {
    private Map<String, String> equalMap;
    private Map<String, List<String>> inMap;
    private Map<String, String> likeMap;
    private Map<String, BetweenValueObject> betweenMap;
    private SortMark sortMark;
    private String orderByClause;
    private List<String> isNullList;
    private Map<String, List<String>> orLikeMap;

    public Map<String, String> getEqualMap() {
        return equalMap;
    }

    public void setEqualMap(Map<String, String> equalMap) {
        this.equalMap = equalMap;
    }

    public Map<String, List<String>> getInMap() {
        return inMap;
    }

    public void setInMap(Map<String, List<String>> inMap) {
        this.inMap = inMap;
    }

    public Map<String, String> getLikeMap() {
        return likeMap;
    }

    public void setLikeMap(Map<String, String> likeMap) {
        this.likeMap = likeMap;
    }

    public Map<String, BetweenValueObject> getBetweenMap() {
        return betweenMap;
    }

    public void setBetweenMap(Map<String, BetweenValueObject> betweenMap) {
        this.betweenMap = betweenMap;
    }

    public SortMark getSortMark() {
        return sortMark;
    }

    public void setSortMark(SortMark sortMark) {
        this.sortMark = sortMark;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public List<String> getIsNullList() {
        return isNullList;
    }

    public void setIsNullList(List<String> isNullList) {
        this.isNullList = isNullList;
    }

    public Map<String, List<String>> getOrLikeMap() {
        return orLikeMap;
    }

    public void setOrLikeMap(Map<String, List<String>> orLikeMap) {
        this.orLikeMap = orLikeMap;
    }

}
