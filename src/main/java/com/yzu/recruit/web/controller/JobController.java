package com.yzu.recruit.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzu.recruit.common.Constant;
import com.yzu.recruit.common.JsonResponse;
import com.yzu.recruit.dataaccess.model.JobEntityExt;
import com.yzu.recruit.service.JobService;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/job/jobEntitys", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<List<JobEntityExt>> queryJobEntitys(HttpServletRequest request,
            HttpServletResponse response) {

        List<JobEntityExt> jobEntityExts = jobService.queryAllJobs();

        return new JsonResponse<List<JobEntityExt>>(Constant.STATUS_SUCCESS, jobEntityExts);

    }
}
