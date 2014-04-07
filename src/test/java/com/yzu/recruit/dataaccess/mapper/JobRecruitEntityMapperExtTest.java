package com.yzu.recruit.dataaccess.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.common.JobRecruitCriteria;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobRecruitEntityMapperExtTest {

    @Autowired
    private JobRecruitEntityMapperExt jobRecruitEntityMapperExt;
    @Autowired
    private DepartmentEntityMapperExt departmentEntityMapperExt;
    @Autowired
    private JobEntityMapperExt jobEntityMapperExt;
    int jobRecruitEntityExtID = 0;
    @Test
    public void testGetJobRecruitEntityExtByID() {
        JobRecruitEntityExt jobRecruitEntityExt = jobRecruitEntityMapperExt.getJobRecruitEntityExtByID(jobRecruitEntityExtID);
        Assert.assertNotNull(jobRecruitEntityExt);
    }

    @Test
    public void testQueryJobRecruitEntityExts() {
        List<JobRecruitEntityExt> jobRecruitEntityExts = jobRecruitEntityMapperExt.queryJobRecruitEntityExts(new JobRecruitCriteria(), new Pagination());
        Assert.assertNotNull(jobRecruitEntityExts);
    }

    @Before
    public void testSaveJobRecruitEntityExt() {
        JobRecruitEntityExt jobRecruitEntityExt = new JobRecruitEntityExt();
        jobRecruitEntityExt.setDepartmentid(1);
        jobRecruitEntityExt.setJobid(1);
        jobRecruitEntityExtID = jobRecruitEntityMapperExt.saveJobRecruitEntityExt(jobRecruitEntityExt);
        jobRecruitEntityExtID = jobRecruitEntityExt.getJobrecruitid();
        Assert.assertTrue(jobRecruitEntityExtID > 0);
    }

    @After
    public void testDeleteJobRecruitEntityExt() {
        JobRecruitEntityExt jobRecruitEntityExt = jobRecruitEntityMapperExt.getJobRecruitEntityExtByID(jobRecruitEntityExtID);
        jobRecruitEntityMapperExt.deleteJobRecruitEntityExt(jobRecruitEntityExt.getJobrecruitid());
        Assert.assertTrue(jobRecruitEntityExtID > 0);
    }
}
