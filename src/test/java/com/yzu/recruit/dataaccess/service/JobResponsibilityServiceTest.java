package com.yzu.recruit.dataaccess.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.dataaccess.model.JobResponsibilityEntityExt;
import com.yzu.recruit.service.JobResponsibilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobResponsibilityServiceTest {
    @Autowired
    private JobResponsibilityService jobResponsibilityService;

    @Test
    public void testUpdateJobResponsibility() {
        List<JobResponsibilityEntityExt> jobResponsibilityEntityExtList = new ArrayList<JobResponsibilityEntityExt>();
        JobResponsibilityEntityExt jobResponsibilityEntityExt = new JobResponsibilityEntityExt();
        jobResponsibilityEntityExt.setJobrecruitid(1);
        jobResponsibilityEntityExtList.add(jobResponsibilityEntityExt);
        jobResponsibilityService.updateJobResponsibility(jobResponsibilityEntityExtList);
    }

    @Test
    public void testSaveJobResponsibility() {
        JobResponsibilityEntityExt jobResponsibilityEntityExt = new JobResponsibilityEntityExt();
        jobResponsibilityEntityExt.setJobrecruitid(1);
        jobResponsibilityService.saveJobResponsibility(jobResponsibilityEntityExt);
        jobResponsibilityService.deleteJobResponsibility(jobResponsibilityEntityExt);
    }

}
