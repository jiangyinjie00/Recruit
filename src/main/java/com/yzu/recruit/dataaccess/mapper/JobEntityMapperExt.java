package com.yzu.recruit.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.JobEntityMapper;
import com.yzu.recruit.dataaccess.model.JobEntityExt;

public interface JobEntityMapperExt extends JobEntityMapper {

    int saveJob(JobEntityExt jobEntityExt);

    JobEntityExt getJobByID(int jobEntityExtID);

    List<JobEntityExt> findAllJobs();

    int deleteJob(@Param("jobID")int jobID);
}
