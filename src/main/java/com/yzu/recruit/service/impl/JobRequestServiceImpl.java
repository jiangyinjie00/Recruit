package com.yzu.recruit.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.mapper.JobRequestEntityMapperExt;
import com.yzu.recruit.dataaccess.model.JobRequestEntityExt;
import com.yzu.recruit.dataaccess.model.JobRequestHistoryEntityExt;
import com.yzu.recruit.service.JobRequestHistoryService;
import com.yzu.recruit.service.JobRequestService;
import com.yzu.recruit.web.converter.JobRequestConverter;

@Service
public class JobRequestServiceImpl implements JobRequestService {

    @Autowired
    private JobRequestEntityMapperExt jobRequestEntityMapperExt;
    @Autowired
    private JobRequestHistoryService jobRequestHistoryService;

    @Override
    public int createJobRequest(int jobrecruitid, int userID) {
        JobRequestEntityExt jobRequestEntityExt = new JobRequestEntityExt();
        jobRequestEntityExt.setJobrecruitid(jobrecruitid);
        jobRequestEntityExt.setUserid(userID);
        jobRequestEntityExt.setStatusid(1);
        jobRequestEntityExt.setStatuschangetime(new Date());
        jobRequestEntityExt.setMarkfordelete(false);
        JobRequestEntityExt jobRequestEntityExtFormat = JobRequestConverter.stringToDate(jobRequestEntityExt);
        int jobRequestEntityMapperExtID = jobRequestEntityMapperExt.insertJobRequest(jobRequestEntityExtFormat);
        JobRequestHistoryEntityExt jobRequestHistoryEntityExt = new JobRequestHistoryEntityExt();
        jobRequestHistoryEntityExt.setJobrequestid(jobRequestEntityMapperExtID);
        jobRequestHistoryEntityExt.setStatusid(1);
        jobRequestHistoryEntityExt.setTimestamp(new Date());
        jobRequestHistoryService.addJobRequestHistory(jobRequestHistoryEntityExt);
        return jobRequestEntityMapperExtID;
    }

    @Override
    public List<JobRequestEntityExt> queryJobRequestByStatusName(String statusName) {
        List<JobRequestEntityExt> jobRequestEntityExts = jobRequestEntityMapperExt.queryJobRequestByStatusName(statusName);
        List<JobRequestEntityExt> jobRequestEntityExtList = new ArrayList<JobRequestEntityExt>();
        for (JobRequestEntityExt jobRequestEntityExt : jobRequestEntityExts) {
            JobRequestEntityExt jobRequestEntityExtFormat = JobRequestConverter.dateToString(jobRequestEntityExt);
            jobRequestEntityExtList.add(jobRequestEntityExtFormat);
        }
        return jobRequestEntityExtList;

    }

    @Override
    public List<JobRequestEntityExt> queryJobRequestByDepartmentID(int departmentID, String statusName) {
        List<JobRequestEntityExt> jobRequestEntityExts = jobRequestEntityMapperExt.queryJobRequestByDepartmentID(departmentID, statusName);
        List<JobRequestEntityExt> jobRequestEntityExtList = new ArrayList<JobRequestEntityExt>();
        for (JobRequestEntityExt jobRequestEntityExt : jobRequestEntityExts) {
            JobRequestEntityExt jobRequestEntityExtFormat = JobRequestConverter.dateToString(jobRequestEntityExt);
            jobRequestEntityExtList.add(jobRequestEntityExtFormat);
        }
        return jobRequestEntityExtList;

    }

    @Override
    public void updateJobRequest(JobRequestEntityExt jobRequestEntityExt) {
        JobRequestHistoryEntityExt jobRequestHistoryEntityExt = new JobRequestHistoryEntityExt();
        jobRequestHistoryEntityExt.setJobrequestid(jobRequestEntityExt.getJobrequestid());
        jobRequestHistoryEntityExt.setStatusid(jobRequestEntityExt.getStatusid());
        jobRequestHistoryEntityExt.setTimestamp(new Date());
        jobRequestHistoryService.addJobRequestHistory(jobRequestHistoryEntityExt);
        jobRequestEntityMapperExt.updateJobRequest(jobRequestEntityExt);
    }

    @Override
    public void updateJobRequestStatus(String opinion, int statusID, int jobRequestID) {
        JobRequestHistoryEntityExt jobRequestHistoryEntityExt = new JobRequestHistoryEntityExt();
        jobRequestHistoryEntityExt.setJobrequestid(jobRequestID);
        jobRequestHistoryEntityExt.setStatusid(statusID);
        jobRequestHistoryEntityExt.setOperationdate(new Date());
        jobRequestHistoryEntityExt.setOpinion(opinion);
        jobRequestHistoryService.addJobRequestHistory(jobRequestHistoryEntityExt);
        jobRequestEntityMapperExt.updateJobRequestStatus(jobRequestID, new Date(), statusID);
    }

    @Override
    public List<JobRequestEntityExt> queryJobRequestByCriteria(int departmentID, int statusID, Pagination pagination) {
        List<JobRequestEntityExt> jobRequestEntityExts = jobRequestEntityMapperExt.queryJobRequestByCriteria(departmentID, statusID, pagination);
        List<JobRequestEntityExt> jobRequestEntityExtList = new ArrayList<JobRequestEntityExt>();
        for (JobRequestEntityExt jobRequestEntityExt : jobRequestEntityExts) {
            JobRequestEntityExt jobRequestEntityExtFormat = JobRequestConverter.dateToString(jobRequestEntityExt);
            jobRequestEntityExtList.add(jobRequestEntityExtFormat);
        }
        return jobRequestEntityExtList;
    }

    @Override
    public int queryAllJobRequestByCriteria(int departmentID, int statusID) {
        return jobRequestEntityMapperExt.queryAllJobRequestByCriteria(departmentID, statusID);
    }

    @Override
    public List<JobRequestEntityExt> queryAuditionJobRequest(Pagination pagination) {
        List<JobRequestEntityExt> jobRequestEntityExts = jobRequestEntityMapperExt.queryAuditionJobRequest(pagination);
        List<JobRequestEntityExt> jobRequestEntityExtList = new ArrayList<JobRequestEntityExt>();
        for (JobRequestEntityExt jobRequestEntityExt : jobRequestEntityExts) {
            JobRequestEntityExt jobRequestEntityExtFormat = JobRequestConverter.dateToString(jobRequestEntityExt);
            jobRequestEntityExtList.add(jobRequestEntityExtFormat);
        }
        return jobRequestEntityExtList;
    }

    @Override
    public int queryAllAuditionJobRequest() {
        return jobRequestEntityMapperExt.queryAllAuditionJobRequest();
    }

    @Override
    public JobRequestEntityExt getJobRequestByID(int jobRequestID) {
        JobRequestEntityExt jobRequestEntityExt = jobRequestEntityMapperExt.selectJobRequestByID(jobRequestID);
        return JobRequestConverter.dateToString(jobRequestEntityExt);
    }

    @Override
    public void releaseAudition(String auditionInfo, String auditionTime, int[] jobRequestArrary) {
        jobRequestEntityMapperExt.releaseAudition(auditionInfo, auditionTime, jobRequestArrary);

    }

    @Override
    public List<JobRequestEntityExt> queryOwnJobRequests(int userID, Pagination pagination) {
        return jobRequestEntityMapperExt.queryOwnJobRequests(userID, pagination);
    }

    @Override
    public int queryAllOwnJobRequests(int userID) {
        return jobRequestEntityMapperExt.queryAllOwnJobRequests(userID);
    }

    @Override
    public void updateAuditionResponse(String opinion, int jobRequestID) {
        Date auditionResponseDate = new Date();
        jobRequestEntityMapperExt.updateAuditionResponse(opinion, auditionResponseDate, jobRequestID);

    }



}