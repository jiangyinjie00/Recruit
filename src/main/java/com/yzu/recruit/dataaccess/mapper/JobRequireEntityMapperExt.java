package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.JobRequireEntityMapper;
import com.yzu.recruit.dataaccess.model.JobRequireEntityExt;

public interface JobRequireEntityMapperExt extends JobRequireEntityMapper {
    int saveJobRequire(JobRequireEntityExt jobRequireEntityExt);

    void updateJobRequire(JobRequireEntityExt jobRequireEntityExt);

    void markForDeleteJobRequire(JobRequireEntityExt jobRequireEntityExt);

    void deleteJobRequire(@Param("jobRequireID")int jobRequireID);
}
