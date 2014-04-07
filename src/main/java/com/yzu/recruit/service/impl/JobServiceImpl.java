package com.yzu.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.JobEntityMapperExt;
import com.yzu.recruit.dataaccess.model.JobEntityExt;
import com.yzu.recruit.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobEntityMapperExt jobEntityMapperExt;

    @Override
    public int addJob(JobEntityExt jobEntityExt) {
        return jobEntityMapperExt.saveJob(jobEntityExt);
    }

    @Override
    public List<JobEntityExt> queryAllJobs() {
        return jobEntityMapperExt.findAllJobs();
    }

}
