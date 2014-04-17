package com.yzu.recruit.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.common.JobRecruitCriteria;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.mapper.gen.JobRecruitEntityMapper;
import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;

public interface JobRecruitEntityMapperExt extends JobRecruitEntityMapper {

    JobRecruitEntityExt getJobRecruitEntityExtByID(@Param("jobRecruitID") int jobRecruitID);

    List<JobRecruitEntityExt> queryJobRecruitEntityExts(@Param("criteria") JobRecruitCriteria criteria, @Param("page")Pagination page);

    int saveJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt);

    int getJobRecruitEntityExtCountByCriateria(@Param("criteria") JobRecruitCriteria criteria);

    int deleteJobRecruitEntityExt(@Param("jobRecruitID") int jobRecruitID);

    List<JobRecruitEntityExt> queryJobRecruitNotApprove(@Param("page")Pagination pagination);

    int queryAllJobRecruitNotApprove();
}
