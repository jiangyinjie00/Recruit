package com.yzu.recruit.web.converter;

import java.util.HashMap;
import java.util.Map;

import com.yzu.recruit.common.CriteriaConstant;
import com.yzu.recruit.common.pagination.CriteriaMap;
import com.yzu.recruit.common.pagination.PageModel;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.common.pagination.SortMark;
import com.yzu.recruit.web.model.RecruitQueryVo;
import com.yzu.recruit.web.model.SearchItem;

public class CriteriaConverter {
    public static CriteriaMap recruitQueryVoToCriteriaMap(RecruitQueryVo query) {

        // Creates instance of Criteria.
        CriteriaMap criteria = new CriteriaMap();

        // Initialization:
        // criteria(OrderBy and sort_desc/_asc).
        PageModel pageModel = query.getPageModel();
        if (null != pageModel) {
            // Inits criteria.();
            String orderByNameForServer = pageModel.getOrderBy();
            if (null != orderByNameForServer
                    && orderByNameForServer.length() > 0) {
                criteria.setOrderByClause(orderByNameForServer);
                if (pageModel.getIsDesc()) {
                    criteria.setSortMark(SortMark.DESC);
                } else {
                    criteria.setSortMark(SortMark.ASC);
                }
            }
        }

        // Equal map:

        Map<String, String> equalMap = new HashMap<String, String>();
        if (null != query.getCity()) {
            equalMap.put(CriteriaConstant.JOB_RECRUIT_CITY, query.getCity());
        }
        if (null != query.getType()) {
            equalMap.put(CriteriaConstant.JOB_RECRUIT_TYPE, query.getType());
        }
        if (!equalMap.isEmpty()) {
            criteria.setEqualMap(equalMap);
        }

        // Like map:
        // Search.
        SearchItem searchItem = query.getSearchItem();
        if (null != searchItem) {
            Map<String, String> likeMap = new HashMap<String, String>();
            if (searchItem.getSearchValue() == null) {
                searchItem.setSearchValue("");
            }
            likeMap.put(searchItem.getSearchKey(),
                    searchItem.getSearchValue());
            criteria.setLikeMap(likeMap);
        }
        // Between map(nothing).

        return criteria;
    }

    public static Pagination toPagination(PageModel pageModel) {
        Pagination pagination = new Pagination();
        pagination.setPageSize(pageModel.getPageSize());
        if (pageModel.getCurrPage() < 0) {
            pagination.setStartRow(0);
        } else {
            pagination.setStartRow((pageModel.getCurrPage() - 1) * pageModel.getPageSize());
        }
        return pagination;
    }
}
