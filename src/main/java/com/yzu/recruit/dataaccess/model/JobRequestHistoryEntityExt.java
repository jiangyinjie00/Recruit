package com.yzu.recruit.dataaccess.model;

import com.yzu.recruit.dataaccess.model.gen.JobRequestHistoryEntity;

public class JobRequestHistoryEntityExt extends JobRequestHistoryEntity {
    private JobRequestEntityExt jobRequestEntityExt;
    private StatusEntityExt statusEntityExt;
    private String operationDateFormat;

    public JobRequestEntityExt getJobRequestEntityExt() {
        return jobRequestEntityExt;
    }

    public void setJobRequestEntityExt(JobRequestEntityExt jobRequestEntityExt) {
        this.jobRequestEntityExt = jobRequestEntityExt;
    }

    public StatusEntityExt getStatusEntityExt() {
        return statusEntityExt;
    }

    public void setStatusEntityExt(StatusEntityExt statusEntityExt) {
        this.statusEntityExt = statusEntityExt;
    }

    public String getOperationDateFormat() {
        return operationDateFormat;
    }

    public void setOperationDateFormat(String operationDateFormat) {
        this.operationDateFormat = operationDateFormat;
    }

}