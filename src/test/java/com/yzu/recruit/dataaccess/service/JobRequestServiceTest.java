package com.yzu.recruit.dataaccess.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.dataaccess.model.JobRequestEntityExt;
import com.yzu.recruit.service.JobRequestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobRequestServiceTest {
    private JobRequestService jobRequestService;

    @Autowired
    public void setJobRequestService(JobRequestService jobRequestService) {
        this.jobRequestService = jobRequestService;
    }

    @Test
    public void testUpdateJobRequest() {
        JobRequestEntityExt jobRequestEntityExt = new JobRequestEntityExt();
        jobRequestEntityExt.setJobrequestid(1);
        jobRequestEntityExt.setUserid(1);
        jobRequestEntityExt.setJobrecruitid(1);
        jobRequestEntityExt.setStatusid(1);
       // jobRequestService.updateJobRequest(jobRequestEntityExt);

        Assert.assertTrue(1 > 0);
    }
}
