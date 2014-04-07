package com.yzu.recruit.web.converter;

import java.util.Date;

import com.yzu.recruit.dataaccess.model.JobRequestEntityExt;
import com.yzu.recruit.util.DateUtil;

public class JobRequestConverter {
    public static JobRequestEntityExt dateToString(JobRequestEntityExt jobRequestEntityExt) {
        if (null != jobRequestEntityExt.getStatuschangetime() && !"".equals(jobRequestEntityExt.getStatuschangetime())) {
            String statusChangeTimeFormat = DateUtil.dateToString(jobRequestEntityExt.getStatuschangetime());
            jobRequestEntityExt.setStatusChangeTimeFormat(statusChangeTimeFormat);
        }
        if (null != jobRequestEntityExt.getAuditiontime() && !"".equals(jobRequestEntityExt.getAuditiontime())) {
            String auditionTimeFormat = DateUtil.dateToString(jobRequestEntityExt.getAuditiontime());
            jobRequestEntityExt.setAuditionTimeFormat(auditionTimeFormat);
        }
        if (null != jobRequestEntityExt.getAuditionrespondtime() && !"".equals(jobRequestEntityExt.getAuditionrespondtime())) {
            String auditionRespondTimeFormat = DateUtil.dateToString(jobRequestEntityExt.getAuditionrespondtime());
            jobRequestEntityExt.setAuditionRespondTimeFormat(auditionRespondTimeFormat);
        }
        return jobRequestEntityExt;
    }

    public static JobRequestEntityExt stringToDate(JobRequestEntityExt jobRequestEntityExt) {
        if (null != jobRequestEntityExt.getStatusChangeTimeFormat() && !"".equals(jobRequestEntityExt.getStatusChangeTimeFormat())) {
            Date statusChangeTime = DateUtil.stringToDate(jobRequestEntityExt.getStatusChangeTimeFormat());
            jobRequestEntityExt.setStatuschangetime(statusChangeTime);
        }
        if (null != jobRequestEntityExt.getAuditionTimeFormat() && !"".equals(jobRequestEntityExt.getAuditionTimeFormat())) {
            Date auditionTime = DateUtil.stringToDate(jobRequestEntityExt.getAuditionTimeFormat());
            jobRequestEntityExt.setAuditiontime(auditionTime);
        }
        if (null != jobRequestEntityExt.getAuditionRespondTimeFormat() && !"".equals(jobRequestEntityExt.getAuditionRespondTimeFormat())) {
            Date auditionRespondTimeFormat = DateUtil.stringToDate(jobRequestEntityExt.getAuditionRespondTimeFormat());
            jobRequestEntityExt.setAuditionrespondtime(auditionRespondTimeFormat);
        }
        return jobRequestEntityExt;
    }
}
