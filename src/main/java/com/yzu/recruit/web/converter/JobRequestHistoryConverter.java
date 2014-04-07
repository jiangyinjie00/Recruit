package com.yzu.recruit.web.converter;

import java.util.Date;

import com.yzu.recruit.dataaccess.model.JobRequestHistoryEntityExt;
import com.yzu.recruit.util.DateUtil;

public class JobRequestHistoryConverter {
    public static JobRequestHistoryEntityExt dateToString(JobRequestHistoryEntityExt jobRequestHistoryEntityExt) {
        if (null != jobRequestHistoryEntityExt.getOperationdate() && !"".equals(jobRequestHistoryEntityExt.getOperationdate())) {
            String operationDateFormat = DateUtil.dateToString(jobRequestHistoryEntityExt.getOperationdate());
            jobRequestHistoryEntityExt.setOperationDateFormat(operationDateFormat);
        }
        return jobRequestHistoryEntityExt;
    }

    public static JobRequestHistoryEntityExt stringToDate(JobRequestHistoryEntityExt jobRequestHistoryEntityExt) {
        if (null != jobRequestHistoryEntityExt.getOperationDateFormat() && !"".equals(jobRequestHistoryEntityExt.getOperationDateFormat())) {
            Date operationDate = DateUtil.stringToDate(jobRequestHistoryEntityExt.getOperationDateFormat());
            jobRequestHistoryEntityExt.setOperationdate(operationDate);
        }
        return jobRequestHistoryEntityExt;
    }
}
