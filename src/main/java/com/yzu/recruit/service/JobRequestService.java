package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.model.JobRequestEntityExt;

public interface JobRequestService {

    List<JobRequestEntityExt> queryJobRequestByCriteria(int departmentID, int statusID, Pagination pagination);

    List<JobRequestEntityExt> queryJobRequestByStatusName(String statusName);

    List<JobRequestEntityExt> queryJobRequestByDepartmentID(int departmentID, String statusName);

    public int createJobRequest(int jobrecruitid, int userID);

    public void updateJobRequest(JobRequestEntityExt jobRequestEntityExt);

    public void updateJobRequestStatus(String opinion, int statusID, int jobRequestID);

    int queryAllJobRequestByCriteria(int departmentID, int statusID);

    List<JobRequestEntityExt> queryAuditionJobRequest(Pagination pagination);

    int queryAllAuditionJobRequest();

    JobRequestEntityExt getJobRequestByID(int jobRequestID);

    void releaseAudition(String auditionInfo, String auditionTime, int[] jobRequestArrary);
}
