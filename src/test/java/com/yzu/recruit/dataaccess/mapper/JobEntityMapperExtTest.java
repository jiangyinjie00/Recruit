package com.yzu.recruit.dataaccess.mapper;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzu.recruit.dataaccess.model.JobEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class JobEntityMapperExtTest {

    @Autowired
    private JobEntityMapperExt jobEntityMapperExt;
    int jobID = 0;

    @Before
    public void testSaveJob() {
        JobEntityExt jobEntityExt = new JobEntityExt();
        jobEntityExt.setName("000");
        jobEntityExt.setIntroduce("000000");
        jobID = jobEntityMapperExt.saveJob(jobEntityExt);
        jobID = jobEntityExt.getJobid();
        Assert.assertTrue(jobID > 0);
    }

    @Test
    public void testGetJob() {
        JobEntityExt jobEntityExt = jobEntityMapperExt.getJobByID(jobID);
        Assert.assertTrue(null != jobEntityExt);
    }

    @After
    public void testDeleteJob() {
        JobEntityExt jobEntityExt = jobEntityMapperExt.getJobByID(jobID);
        jobEntityMapperExt.deleteJob(jobEntityExt.getJobid());
        Assert.assertTrue(null != jobEntityExt);
    }
}
