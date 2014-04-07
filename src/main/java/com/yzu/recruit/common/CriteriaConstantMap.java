package com.yzu.recruit.common;

import java.util.HashMap;
import java.util.Map;
public class CriteriaConstantMap {
    public static Map<String, String> getRecruitMap() {
        Map<String, String> recruitColumnKeyMap = new HashMap<String, String>();
        recruitColumnKeyMap.put(CriteriaConstant.JOB_RECRUIT_ID, "JobRecruitID");
        return recruitColumnKeyMap;
    }
}
