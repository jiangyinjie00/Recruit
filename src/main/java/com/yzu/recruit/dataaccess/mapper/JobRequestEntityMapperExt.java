package com.yzu.recruit.dataaccess.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.mapper.gen.JobRequestEntityMapper;
import com.yzu.recruit.dataaccess.model.JobRequestEntityExt;

public interface JobRequestEntityMapperExt extends JobRequestEntityMapper {

    int insertJobRequest(JobRequestEntityExt jobRequestEntityExt);

    JobRequestEntityExt selectJobRequestByID(@Param("jobRequestID") int jobRequestID);

    List<JobRequestEntityExt> queryJobRequestByCriteria(@Param("departmentID") int departmentID, @Param("statusID")int statusID, @Param("page")Pagination pagination);

    List<JobRequestEntityExt> queryJobRequestByStatusName(@Param("statusName") String statusName);

    List<JobRequestEntityExt> queryJobRequestByDepartmentID(@Param("departmentID") int departmentID, @Param("statusName") String statusName);

    void markForDeleteJobRequest(JobRequestEntityExt jobRequestEntityExt);

    void updateJobRequest(JobRequestEntityExt jobRequestEntityExt);

    int queryAllJobRequestByCriteria(@Param("departmentID")int departmentID, @Param("statusID")int statusID);

    int deleteJobRequest(JobRequestEntityExt jobRequestEntityExt);

    List<JobRequestEntityExt> queryAuditionJobRequest(@Param("page")Pagination pagination);

    int queryAllAuditionJobRequest();

    void updateJobRequestStatus(@Param("jobRequestID")int jobRequestID, @Param("statusChangeTime")Date statusChangeTime, @Param("statusID")  int statusID);

    void releaseAudition(@Param("auditionInfo")String auditionInfo, @Param("auditionTime")String auditionTime, @Param("jobRequestIDs")int[] jobRequestArrary);

    List<JobRequestEntityExt> queryOwnJobRequests(@Param("userID")int userID, @Param("page")Pagination pagination);

    int queryAllOwnJobRequests(@Param("userID")int userID);

    void updateAuditionResponse(@Param("auditionResponse")String opinion, @Param("auditionResponseTime")Date auditionResponseDate, @Param("jobRequestID")int jobRequestID);
}
