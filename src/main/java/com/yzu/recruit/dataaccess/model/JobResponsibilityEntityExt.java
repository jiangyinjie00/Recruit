package com.yzu.recruit.dataaccess.model;

import com.yzu.recruit.dataaccess.model.gen.JobResponsibilityEntity;

public class JobResponsibilityEntityExt extends JobResponsibilityEntity {
    private JobRecruitEntityExt jobRecruitEntityExt;
    
    public JobRecruitEntityExt getJobRecruitEntityExt() {
        return jobRecruitEntityExt;
    }
    
    public void setJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt) {
        this.jobRecruitEntityExt = jobRecruitEntityExt;
    }

}
