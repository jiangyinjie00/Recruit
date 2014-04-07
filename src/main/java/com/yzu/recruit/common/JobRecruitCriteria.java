package com.yzu.recruit.common;

import java.util.HashMap;
import java.util.Map;

import com.yzu.recruit.common.pagination.BaseCriteria;

public class JobRecruitCriteria extends BaseCriteria {

   private static Map<String, String> columnKeyMap = new HashMap<String, String>();

   static {
       columnKeyMap.put(CriteriaConstant.JOB_RECRUIT_CITY, "_JobRecruit.City");
       columnKeyMap.put(CriteriaConstant.JOB_RECRUIT_NAME, "_Job.Name");
       columnKeyMap.put(CriteriaConstant.JOB_RECRUIT_TYPE, "_JobRecruit.Type");
       columnKeyMap.put(CriteriaConstant.JOB_RECRUIT_ID, "_JobRecruit.JobRecruitID");
       columnKeyMap.put(CriteriaConstant.JOB_RECRUIT_TIMESTAMP, "_JobRecruit.Timestamp");

   }
    @Override
    protected String getMapValue(String columnKey) {
        if (columnKeyMap.containsKey(columnKey)) {
            return columnKeyMap.get(columnKey);
        }
        return null;

    }

}
