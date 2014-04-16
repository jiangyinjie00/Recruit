package com.yzu.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.JobResponsibilityEntityMapperExt;
import com.yzu.recruit.dataaccess.model.JobResponsibilityEntityExt;
import com.yzu.recruit.service.JobResponsibilityService;

@Service
public class JobResponsibilityServiceImpl implements JobResponsibilityService {

    @Autowired
    private JobResponsibilityEntityMapperExt jobResponsibilityEntityMapperExt;

    @Override
    public int saveJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt) {
        return jobResponsibilityEntityMapperExt.saveJobResponsibility(jobResponsibilityEntityExt);
    }

    @Override
    public void updateJobResponsibility(List<JobResponsibilityEntityExt> jobResponsibilityEntityExtList, int jobRecruitID) {
        for (JobResponsibilityEntityExt jobResponsibilityEntityExt : jobResponsibilityEntityExtList) {
            if (null != jobResponsibilityEntityExt.getJobresponsibilityid() && jobResponsibilityEntityExt.getJobresponsibilityid() > 0) {
                if (jobResponsibilityEntityExt.getMarkfordelete()) {
                    jobResponsibilityEntityMapperExt.updateJobResponsibility(jobResponsibilityEntityExt);
                } else {
                    jobResponsibilityEntityMapperExt.markForDeleteJobResponsibility(jobResponsibilityEntityExt);
                }
            } else {
                jobResponsibilityEntityExt.setJobrecruitid(jobRecruitID);
                jobResponsibilityEntityMapperExt.saveJobResponsibility(jobResponsibilityEntityExt);
            }
        }
    }

    @Override
    public void markForDeleteJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt) {
        jobResponsibilityEntityMapperExt.markForDeleteJobResponsibility(jobResponsibilityEntityExt);
    }

    @Override
    public void deleteJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt) {
        jobResponsibilityEntityMapperExt.deleteJobResponsibility(jobResponsibilityEntityExt.getJobrecruitid());
    }

}
