package com.yzu.recruit.dataaccess.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.dataaccess.model.JobRequireEntityExt;
import com.yzu.recruit.service.JobRequestService;
import com.yzu.recruit.service.JobRequireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobRequireServiceTest {

    @Autowired
    private JobRequestService jobRequestService;
    @Autowired
    private JobRequireService jobRequireService;

    @Before
    public void testInsertJobRequire() {
        JobRequireEntityExt jobRequireEntityExt = new JobRequireEntityExt();
        jobRequireEntityExt.setJobrecruitid(1);
        jobRequireService.addJobRequire(jobRequireEntityExt);
        jobRequireService.deleteJobRequire(jobRequireEntityExt);
    }

    @Test
    public void testUpdateJobRequire() {
        List<JobRequireEntityExt> jobRequireEntityExtList = new ArrayList<JobRequireEntityExt>();
        JobRequireEntityExt jobRequireEntityExt = new JobRequireEntityExt();
        jobRequireEntityExt.setJobrecruitid(1);
        jobRequireEntityExtList.add(jobRequireEntityExt);
        jobRequireService.updateJobRequire(jobRequireEntityExtList);
    }

}
