package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.JobResponsibilityEntityMapper;
import com.yzu.recruit.dataaccess.model.JobResponsibilityEntityExt;

public interface JobResponsibilityEntityMapperExt extends JobResponsibilityEntityMapper {

    int saveJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt);

    void markForDeleteJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt);

    void updateJobResponsibility(JobResponsibilityEntityExt jobResponsibilityEntityExt);

    void deleteJobResponsibility(@Param("jobResponsibilityID")int jobResponsibilityID);

}
