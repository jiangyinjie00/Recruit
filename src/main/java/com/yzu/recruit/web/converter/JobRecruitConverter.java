package com.yzu.recruit.web.converter;

import java.util.Date;

import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;
import com.yzu.recruit.util.DateUtil;

public class JobRecruitConverter {
    public static JobRecruitEntityExt dateToString(JobRecruitEntityExt jobRecruitEntityExt) {
        if (null != jobRecruitEntityExt.getStarttime() && !"".equals(jobRecruitEntityExt.getStarttime())) {
            String startTimeFormat = DateUtil.dateToString(jobRecruitEntityExt.getStarttime());
            jobRecruitEntityExt.setStartTimeFormat(startTimeFormat);
        }
        if (null != jobRecruitEntityExt.getExpiretime() && !"".equals(jobRecruitEntityExt.getExpiretime())) {
            String expireTimeFormat = DateUtil.dateToString(jobRecruitEntityExt.getExpiretime());
            jobRecruitEntityExt.setExpireTimeFormat(expireTimeFormat);
        }
        return jobRecruitEntityExt;
    }

    public static JobRecruitEntityExt stringToDate(JobRecruitEntityExt jobRecruitEntityExt) {
        if (null != jobRecruitEntityExt.getStartTimeFormat() && !"".equals(jobRecruitEntityExt.getStartTimeFormat())) {
            Date startTime = DateUtil.stringToDate(jobRecruitEntityExt.getStartTimeFormat());
            jobRecruitEntityExt.setStarttime(startTime);
        }
        if (null != jobRecruitEntityExt.getExpireTimeFormat() && !"".equals(jobRecruitEntityExt.getExpireTimeFormat())) {
            Date expireTime = DateUtil.stringToDate(jobRecruitEntityExt.getExpireTimeFormat());
            jobRecruitEntityExt.setExpiretime(expireTime);
        }
        return jobRecruitEntityExt;
    }

}
