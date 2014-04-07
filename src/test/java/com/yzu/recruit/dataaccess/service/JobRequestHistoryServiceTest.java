package com.yzu.recruit.dataaccess.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.dataaccess.model.JobRequestHistoryEntityExt;
import com.yzu.recruit.service.JobRequestHistoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobRequestHistoryServiceTest {
    @Autowired
    private JobRequestHistoryService jobRequestHistoryService;
    int jobRequestHistoryEntityExtId = 0;

    @Before
    public void testAddJobRequestHistory() {
        JobRequestHistoryEntityExt jobRequestHistoryEntityExt = new JobRequestHistoryEntityExt();
        jobRequestHistoryEntityExt.setJobrequestid(1);
        jobRequestHistoryEntityExt.setStatusid(1);
        jobRequestHistoryEntityExt.setTimestamp(new Date());
        jobRequestHistoryEntityExtId = jobRequestHistoryService.addJobRequestHistory(jobRequestHistoryEntityExt);
        Assert.assertTrue(1 < jobRequestHistoryEntityExtId);
        jobRequestHistoryService.deleteJobRequestHistory(jobRequestHistoryEntityExt);
    }

    @Test
    public void testQueryJobRequestHistorysByJobrequestid() {
        List<JobRequestHistoryEntityExt> jobRequestHistoryEntityExts = jobRequestHistoryService.queryJobRequestHistorysByJobrequestid(1);
        Assert.assertTrue(null != jobRequestHistoryEntityExts && !jobRequestHistoryEntityExts.isEmpty());
    }

    @Ignore
    public void testDeleteJobRequestHistory() {
        List<JobRequestHistoryEntityExt> jobRequestHistoryEntityExts = jobRequestHistoryService.queryJobRequestHistorysByJobrequestid(1);
        jobRequestHistoryService.deleteJobRequestHistory(jobRequestHistoryEntityExts.get(0));
    }
}
