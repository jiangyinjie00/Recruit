package com.yzu.recruit.service.impl;

import java.util.ArrayList;
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
        criteria.convertCriteria(criteria, criteriaMap);
        List<JobRecruitEntityExt>  list = jobRecruitEntityMapperExt.queryJobRecruitEntityExts(criteria, pagination);
        List<JobRecruitEntityExt> jobRecruitEntityExts = new ArrayList<JobRecruitEntityExt>();
        for (JobRecruitEntityExt jobRecruitEntityExt : list) {
            JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.dateToString(jobRecruitEntityExt);
            jobRecruitEntityExts.add(jobRecruitEntityExtFormat);
        }
        PageModel pageModel = new PageModel();
        int total = jobRecruitEntityMapperExt.getJobRecruitEntityExtCountByCriateria(criteria);
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
        jobRecruitEntityMapperExt.saveJobRecruitEntityExt(jobRecruitEntityExtFormat);
        int jobrecruitid = jobRecruitEntityExt.getJobrecruitid();
        List<JobRequireEntityExt> jobRequireEntityExts = jobRecruitEntityExt.getJobRequireEntityExts();
        List<JobResponsibilityEntityExt> jobResponsibilityEntityExts = jobRecruitEntityExt.getJobResponsibilityEntityExts();
        jobRequireService.updateJobRequire(jobRequireEntityExts, jobrecruitid);
        jobResponsibilityService.updateJobResponsibility(jobResponsibilityEntityExts, jobrecruitid);
    }

    @Override
    public List<JobRecruitEntityExt> queryJobRecruitNotApprove(Pagination pagination) {
        List<JobRecruitEntityExt>  list = jobRecruitEntityMapperExt.queryJobRecruitNotApprove(pagination);
        List<JobRecruitEntityExt> jobRecruitEntityExts = new ArrayList<JobRecruitEntityExt>();
        for (JobRecruitEntityExt jobRecruitEntityExt : list) {
            JobRecruitEntityExt jobRecruitEntityExtFormat = JobRecruitConverter.dateToString(jobRecruitEntityExt);
            jobRecruitEntityExts.add(jobRecruitEntityExtFormat);
        }
        return jobRecruitEntityExts;
    }

    @Override
    public int queryAllJobRecruitNotApprove() {
        return jobRecruitEntityMapperExt.queryAllJobRecruitNotApprove();
    }

}
