package com.yzu.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.JobRequireEntityMapperExt;
import com.yzu.recruit.dataaccess.model.JobRequireEntityExt;
import com.yzu.recruit.service.JobRequireService;

@Service
public class JobRequireServiceImpl implements JobRequireService {

    @Autowired
    private JobRequireEntityMapperExt jobRequireEntityMapperExt;

    @Override
    public int addJobRequire(JobRequireEntityExt jobRequireEntityExt) {
        return jobRequireEntityMapperExt.saveJobRequire(jobRequireEntityExt);
    }

    @Override
    public void updateJobRequire(List<JobRequireEntityExt> jobRequireEntityExtList, int jobRecruitID) {
        for (JobRequireEntityExt jobRequireEntityExt : jobRequireEntityExtList) {
            if (null != jobRequireEntityExt.getJobrequireid() && jobRequireEntityExt.getJobrequireid() > 0) {
                if (jobRequireEntityExt.getMarkfordelete()) {
                    jobRequireEntityMapperExt.updateJobRequire(jobRequireEntityExt);
                } else {
                    jobRequireEntityMapperExt.markForDeleteJobRequire(jobRequireEntityExt);
                }
            } else {
                jobRequireEntityExt.setJobrecruitid(jobRecruitID);
                jobRequireEntityMapperExt.saveJobRequire(jobRequireEntityExt);
            }
        }
    }

    @Override
    public void deleteJobRequire(JobRequireEntityExt jobRequireEntityExt) {
        jobRequireEntityMapperExt.deleteJobRequire(jobRequireEntityExt.getJobrecruitid());
    }

}
