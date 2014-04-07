package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.dataaccess.model.JobResponsibilityEntityExt;

public interface JobResponsibilityService {
    public int saveJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt);

    public void updateJobResponsibility(List<JobResponsibilityEntityExt> jobResponsibilityEntityExtList);

    public void markForDeleteJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt);

    public void deleteJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt);
}
