package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.dataaccess.model.JobRequireEntityExt;

public interface JobRequireService {
    public int addJobRequire(JobRequireEntityExt jobRequireEntityExt);

    public void updateJobRequire(List<JobRequireEntityExt> jobRequireEntityExtList);

    public void deleteJobRequire(JobRequireEntityExt jobRequireEntityExt);
}
