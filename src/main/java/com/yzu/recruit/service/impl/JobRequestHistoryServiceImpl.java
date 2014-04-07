package com.yzu.recruit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.JobRequestHistoryEntityMapperExt;
import com.yzu.recruit.dataaccess.model.JobRequestHistoryEntityExt;
import com.yzu.recruit.service.JobRequestHistoryService;
import com.yzu.recruit.web.converter.JobRequestHistoryConverter;

@Service
public class JobRequestHistoryServiceImpl implements JobRequestHistoryService {

    @Autowired
    private JobRequestHistoryEntityMapperExt jobRequestHistoryEntityMapperExt;

    @Override
    public int addJobRequestHistory(JobRequestHistoryEntityExt jobRequestHistoryEntityExt) {
        JobRequestHistoryEntityExt jobRequestHistoryEntityExtFormat = JobRequestHistoryConverter.stringToDate(jobRequestHistoryEntityExt);
        jobRequestHistoryEntityMapperExt.insertJobRequestHistory(jobRequestHistoryEntityExtFormat);
        return jobRequestHistoryEntityExt.getJobrequesthistoryid();
    }

    @Override
    public List<JobRequestHistoryEntityExt> queryJobRequestHistorysByJobrequestid(int jobrequestId) {
        List<JobRequestHistoryEntityExt> jobRequestHistoryEntityExts = jobRequestHistoryEntityMapperExt.queryJobRequestHistorysByJobrequestid(jobrequestId);
        List<JobRequestHistoryEntityExt> jobRequestHistoryEntityExtList = new ArrayList<JobRequestHistoryEntityExt>();
        for (JobRequestHistoryEntityExt jobRequestHistoryEntityExt : jobRequestHistoryEntityExts) {
            JobRequestHistoryEntityExt jobRequestHistoryEntityExtFormat = JobRequestHistoryConverter.dateToString(jobRequestHistoryEntityExt);
            jobRequestHistoryEntityExtList.add(jobRequestHistoryEntityExtFormat);
        }
        return jobRequestHistoryEntityExtList;
    }

    @Override
    public void deleteJobRequestHistory(JobRequestHistoryEntityExt jobRequestHistoryEntityExt) {
        jobRequestHistoryEntityMapperExt.deleteJobRequestHistory(jobRequestHistoryEntityExt.getJobrequesthistoryid());
    }

}
