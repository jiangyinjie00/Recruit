package com.yzu.recruit.dataaccess.model;

import java.util.List;

import com.yzu.recruit.dataaccess.model.gen.JobRequestEntity;

public class JobRequestEntityExt extends JobRequestEntity {
    private String remark;
    private String auditioninfo;
    private String auditionrespond;
    private String auditionremark;
    private JobRecruitEntityExt jobRecruitEntityExt;
    private UserEntityExt userEntityExt;
    private StatusEntityExt statusEntityExt;
    private List<JobRequestHistoryEntityExt> jobRequestHistoryEntityExts;
    private String statusChangeTimeFormat;
    private String auditionTimeFormat;
    private String auditionRespondTimeFormat;
    private String createTimeFormat;

    public List<JobRequestHistoryEntityExt> getJobRequestHistoryEntityExts() {
        return jobRequestHistoryEntityExts;
    }

    public void setJobRequestHistoryEntityExts(List<JobRequestHistoryEntityExt> jobRequestHistoryEntityExts) {
        this.jobRequestHistoryEntityExts = jobRequestHistoryEntityExts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditioninfo() {
        return auditioninfo;
    }

    public void setAuditioninfo(String auditioninfo) {
        this.auditioninfo = auditioninfo;
    }

    public String getAuditionrespond() {
        return auditionrespond;
    }

    public void setAuditionrespond(String auditionrespond) {
        this.auditionrespond = auditionrespond;
    }

    public String getAuditionremark() {
        return auditionremark;
    }

    public void setAuditionremark(String auditionremark) {
        this.auditionremark = auditionremark;
    }

    public JobRecruitEntityExt getJobRecruitEntityExt() {
        return jobRecruitEntityExt;
    }

    public void setJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt) {
        this.jobRecruitEntityExt = jobRecruitEntityExt;
    }

    public UserEntityExt getUserEntityExt() {
        return userEntityExt;
    }

    public void setUserEntityExt(UserEntityExt userEntityExt) {
        this.userEntityExt = userEntityExt;
    }

    public StatusEntityExt getStatusEntityExt() {
        return statusEntityExt;
    }

    public void setStatusEntityExt(StatusEntityExt statusEntityExt) {
        this.statusEntityExt = statusEntityExt;
    }

    public String getStatusChangeTimeFormat() {
        return statusChangeTimeFormat;
    }

    public void setStatusChangeTimeFormat(String statusChangeTimeFormat) {
        this.statusChangeTimeFormat = statusChangeTimeFormat;
    }

    public String getAuditionTimeFormat() {
        return auditionTimeFormat;
    }

    public void setAuditionTimeFormat(String auditionTimeFormat) {
        this.auditionTimeFormat = auditionTimeFormat;
    }

    public String getAuditionRespondTimeFormat() {
        return auditionRespondTimeFormat;
    }

    public void setAuditionRespondTimeFormat(String auditionRespondTimeFormat) {
        this.auditionRespondTimeFormat = auditionRespondTimeFormat;
    }

    public String getCreateTimeFormat() {
        return createTimeFormat;
    }

    public void setCreateTimeFormat(String createTimeFormat) {
        this.createTimeFormat = createTimeFormat;
    }

}