package com.yzu.recruit.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.common.JobRecruitCriteria;
import com.yzu.recruit.common.pagination.CriteriaMap;
import com.yzu.recruit.common.pagination.PageDataModel;
import com.yzu.recruit.common.pagination.PageModel;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.mapper.JobRecruitEntityMapperExt;
import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;
import com.yzu.recruit.dataaccess.model.JobRequireEntityExt;
import com.yzu.recruit.dataaccess.model.JobResponsibilityEntityExt;
import com.yzu.recruit.service.JobRecruitService;
import com.yzu.recruit.service.JobRequireService;
import com.yzu.recruit.service.JobResponsibilityService;
import com.yzu.recruit.web.converter.JobRecruitConverter;

@Service
public class JobRecruitServiceImpl implements JobRecruitService {

    @Autowired
    private JobRecruitEntityMapperExt jobRecruitEntityMapperExt;
    @Autowired
    private JobRequireService jobRequireService;
    @Autowired
    private JobResponsibilityService jobResponsibilityService;

    @Override
    public JobRecruitEntityExt getJobRecruitEntityExtById(int JobRecruitEntityExtId) {
        JobRecruitEntityExt jobRecruitEntityExt = jobRecruitEntityMapperExt.getJobRecruitEntityExtByID(JobRecruitEntityExtId);
        return JobRecruitConverter.dateToString(jobRecruitEntityExt);
    }

    @Override
    public int addJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt) {
        JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.stringToDate(jobRecruitEntityExt);
        jobRecruitEntityMapperExt.saveJobRecruitEntityExt(jobRecruitEntityExtFormat);
        int jobrecruitid = jobRecruitEntityExt.getJobrecruitid();
        List<JobRequireEntityExt> jobRequireEntityExts = jobRecruitEntityExt.getJobRequireEntityExts();
        List<JobResponsibilityEntityExt> jobResponsibilityEntityExts = jobRecruitEntityExt.getJobResponsibilityEntityExts();
        if (null != jobRequireEntityExts && !jobRequireEntityExts.isEmpty()) {
            for (JobRequireEntityExt jobRequireEntityExt : jobRequireEntityExts) {
                jobRequireEntityExt.setJobrecruitid(jobrecruitid);
                jobRequireService.addJobRequire(jobRequireEntityExt);
            }
        }
        if (null != jobResponsibilityEntityExts && !jobResponsibilityEntityExts.isEmpty()) {
            for (JobResponsibilityEntityExt jobResponsibilityEntityExt : jobResponsibilityEntityExts) {
                jobResponsibilityEntityExt.setJobrecruitid(jobrecruitid);
                jobResponsibilityService.saveJobResponsibility(jobResponsibilityEntityExt);
            }
        }
        return jobrecruitid;
    }


    @Override
    public PageDataModel<JobRecruitEntityExt> queryJobRecruitEntityExts(CriteriaMap criteriaMap, Pagination pagination) {
        PageDataModel<JobRecruitEntityExt> jobRecruitPageModel = new PageDataModel<JobRecruitEntityExt>();
        JobRecruitCriteria criteria = new JobRecruitCriteria();
        Date currentDate = new Date();
        criteria.convertCriteria(criteria, criteriaMap);
        List<JobRecruitEntityExt>  list = jobRecruitEntityMapperExt.queryJobRecruitEntityExts(criteria, pagination, currentDate);
        List<JobRecruitEntityExt> jobRecruitEntityExts = new ArrayList<JobRecruitEntityExt>();
        for (JobRecruitEntityExt jobRecruitEntityExt : list) {
            JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.dateToString(jobRecruitEntityExt);
            jobRecruitEntityExts.add(jobRecruitEntityExtFormat);
        }
        PageModel pageModel = new PageModel();
        int total = jobRecruitEntityMapperExt.getJobRecruitEntityExtCountByCriateria(criteria, currentDate);
        pageModel.setRowCount(total);
        jobRecruitPageModel.setData(jobRecruitEntityExts);
        jobRecruitPageModel.setPaging(pageModel);
        return jobRecruitPageModel;
    }

    @Override
    public int deleteJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt) {
        return jobRecruitEntityMapperExt.deleteJobRecruitEntityExt(jobRecruitEntityExt.getJobrecruitid());
    }

    @Override
    public void updateJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt) {
        JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.stringToDate(jobRecruitEntityExt);
        jobRecruitEntityMapperExt.updateByJobRecruitID(jobRecruitEntityExtFormat);
        int jobrecruitid = jobRecruitEntityExt.getJobrecruitid();
        List<JobRequireEntityExt> jobRequireEntityExts = jobRecruitEntityExt.getJobRequireEntityExts();
        List<JobResponsibilityEntityExt> jobResponsibilityEntityExts = jobRecruitEntityExt.getJobResponsibilityEntityExts();
        jobRequireService.updateJobRequire(jobRequireEntityExts, jobrecruitid);
        jobResponsibilityService.updateJobResponsibility(jobResponsibilityEntityExts, jobrecruitid);
    }

    @Override
    public List<JobRecruitEntityExt> queryJobRecruitNotApprove(Pagination pagination) {
        Date currentDate = new Date();
        List<JobRecruitEntityExt>  list = jobRecruitEntityMapperExt.queryJobRecruitNotApprove(pagination, currentDate);
        List<JobRecruitEntityExt> jobRecruitEntityExts = new ArrayList<JobRecruitEntityExt>();
        for (JobRecruitEntityExt jobRecruitEntityExt : list) {
            JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.dateToString(jobRecruitEntityExt);
            jobRecruitEntityExts.add(jobRecruitEntityExtFormat);
        }
        return jobRecruitEntityExts;
    }

    @Override
    public int queryAllJobRecruitNotApprove() {
        Date currentDate = new Date();
        return jobRecruitEntityMapperExt.queryAllJobRecruitNotApprove(currentDate);
    }

    @Override
    public List<JobRecruitEntityExt> queryFinishedJobs(Pagination pagination) {
        Date currentDate = new Date();
        List<JobRecruitEntityExt>  list = jobRecruitEntityMapperExt.queryFinishedJobs(pagination, currentDate);
        List<JobRecruitEntityExt> jobRecruitEntityExts = new ArrayList<JobRecruitEntityExt>();
        for (JobRecruitEntityExt jobRecruitEntityExt : list) {
            JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.dateToString(jobRecruitEntityExt);
            jobRecruitEntityExts.add(jobRecruitEntityExtFormat);
        }
        return jobRecruitEntityExts;
    }

    @Override
    public int queryAllFinishedJobs() {
        Date currentDate = new Date();
        return jobRecruitEntityMapperExt.queryAllFinishedJobs(currentDate);
    }

    @Override
    public int restartJobRecruitEntityExt(JobRecruitEntityExt jobRecruitEntityExt) {
        JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.stringToDate(jobRecruitEntityExt);
        jobRecruitEntityMapperExt.saveJobRecruitEntityExt(jobRecruitEntityExtFormat);
        int jobrecruitid = jobRecruitEntityExt.getJobrecruitid();
        List<JobRequireEntityExt> jobRequireEntityExts = jobRecruitEntityExt.getJobRequireEntityExts();
        List<JobResponsibilityEntityExt> jobResponsibilityEntityExts = jobRecruitEntityExt.getJobResponsibilityEntityExts();
        if (null != jobRequireEntityExts && !jobRequireEntityExts.isEmpty()) {

            for (JobRequireEntityExt jobRequireEntityExt : jobRequireEntityExts) {
                jobRequireEntityExt.setJobrecruitid(jobrecruitid);
                if (null != jobRequireEntityExt.getJobrequireid() && jobRequireEntityExt.getJobrequireid() > 0) {
                    if (!jobRequireEntityExt.getMarkfordelete()) {
                        jobRequireService.addJobRequire(jobRequireEntityExt);
                    }
                } else {
                    jobRequireService.addJobRequire(jobRequireEntityExt);
                }
            }
        }
        if (null != jobResponsibilityEntityExts && !jobResponsibilityEntityExts.isEmpty()) {
            for (JobResponsibilityEntityExt jobResponsibilityEntityExt : jobResponsibilityEntityExts) {
                jobResponsibilityEntityExt.setJobrecruitid(jobrecruitid);
                if (null != jobResponsibilityEntityExt.getJobresponsibilityid() && jobResponsibilityEntityExt.getJobresponsibilityid() > 0) {
                    if (!jobResponsibilityEntityExt.getMarkfordelete()) {
                        jobResponsibilityService.saveJobResponsibility(jobResponsibilityEntityExt);
                    }
                } else {
                    jobResponsibilityService.saveJobResponsibility(jobResponsibilityEntityExt);
                }
            }
        }
        return jobrecruitid;
    }

}
