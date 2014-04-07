package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.dataaccess.model.JobEntityExt;

public interface JobService {
    int addJob(JobEntityExt jobEntityExt);

    List<JobEntityExt> queryAllJobs();
}
