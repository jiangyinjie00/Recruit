package com.yzu.recruit.dataaccess.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;
import com.yzu.recruit.service.JobRecruitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobRecruitServiceTest {
    @Autowired
    private JobRecruitService jobRecruitService;
    int JobRecruitEntityExtId = 0;

    @Before
    public void testAddJobRecruitEntityExt() {
        JobRecruitEntityExt jobRecruitEntityExt = new JobRecruitEntityExt();
        jobRecruitEntityExt.setDepartmentid(1);
        jobRecruitEntityExt.setJobid(1);
        JobRecruitEntityExtId = jobRecruitService.addJobRecruitEntityExt(jobRecruitEntityExt);
        Assert.assertTrue(1 < JobRecruitEntityExtId);
    }

    @Test
    public void testGetJobRecruitEntityExt() {
        JobRecruitEntityExt jobRecruitEntityExt = jobRecruitService.getJobRecruitEntityExtById(JobRecruitEntityExtId);
        Assert.assertTrue(1 < jobRecruitEntityExt.getJobrecruitid());
    }
    @After
    public void testDeleteJobRecruitEntityExt() {
        JobRecruitEntityExt jobRecruitEntityExt = jobRecruitService.getJobRecruitEntityExtById(JobRecruitEntityExtId);
        int id = jobRecruitService.deleteJobRecruitEntityExt(jobRecruitEntityExt);
        Assert.assertTrue(1 == id);
    }
}
