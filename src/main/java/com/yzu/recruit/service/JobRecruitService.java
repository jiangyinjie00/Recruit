package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.common.pagination.CriteriaMap;
import com.yzu.recruit.common.pagination.PageDataModel;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;

public interface JobRecruitService {
    JobRecruitEntityExt getJobRecruitEntityExtById(int JobRecruitEntityExtId);

    PageDataModel<JobRecruitEntityExt> queryJobRecruitEntityExts(CriteriaMap criteriaMap, Pagination pagination);

    int addJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt);

    int deleteJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt);

    void updateJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt);

    List<JobRecruitEntityExt> queryJobRecruitNotApprove(Pagination pagination);

    int queryAllJobRecruitNotApprove();

    List<JobRecruitEntityExt> queryFinishedJobs(Pagination pagination);

    int queryAllFinishedJobs();
}
