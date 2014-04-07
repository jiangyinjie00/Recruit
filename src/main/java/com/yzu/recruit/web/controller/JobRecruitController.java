package com.yzu.recruit.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzu.recruit.common.Constant;
import com.yzu.recruit.common.JsonResponse;
import com.yzu.recruit.common.pagination.CriteriaMap;
import com.yzu.recruit.common.pagination.PageDataModel;
import com.yzu.recruit.common.pagination.PageModel;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.model.DepartmentEntityExt;
import com.yzu.recruit.dataaccess.model.JobRecruitEntityExt;
import com.yzu.recruit.service.DepartmentService;
import com.yzu.recruit.service.JobRecruitService;
import com.yzu.recruit.web.converter.CriteriaConverter;
import com.yzu.recruit.web.model.RecruitQueryVo;
import com.yzu.recruit.web.model.UserModel;

@Controller
public class JobRecruitController {

    @Autowired
    private JobRecruitService jobRecruitService;

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/job/jobDetail/{jobRecruitID}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<JobRecruitEntityExt> getJobDetail(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int jobRecruitID) {
        JobRecruitEntityExt jobRecruitEntityExt = jobRecruitService
                .getJobRecruitEntityExtById(jobRecruitID);
        return new JsonResponse<JobRecruitEntityExt>(Constant.STATUS_SUCCESS, jobRecruitEntityExt);

    }

    @RequestMapping(value = "/job/createJobRecruit", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> createJobRecruit(HttpServletRequest request,
            HttpServletResponse response, @RequestBody JobRecruitEntityExt jobRecruitEntityExt) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        DepartmentEntityExt department = departmentService.getDepartmentByUserID(userModel.getUserID());
        jobRecruitEntityExt.setDepartmentid(department.getDepartmentid());
        int jobRecruitID = jobRecruitService.addJobRecruitEntityExt(jobRecruitEntityExt);
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, jobRecruitID);

    }

    @RequestMapping(value = "/job/jobs", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PageDataModel<JobRecruitEntityExt>> queryJobs(HttpServletRequest request,
            HttpServletResponse response, @RequestBody RecruitQueryVo recruitQueryVo) {

        CriteriaMap criteriaMap = CriteriaConverter.recruitQueryVoToCriteriaMap(recruitQueryVo);
        Pagination pagination = CriteriaConverter.toPagination(recruitQueryVo.getPageModel());

        PageDataModel<JobRecruitEntityExt> jobRecruitPageModel = jobRecruitService
                .queryJobRecruitEntityExts(criteriaMap, pagination);

        PageModel pageModel = recruitQueryVo.getPageModel();
        pageModel.setRowCount(jobRecruitPageModel.getPaging().getRowCount());
        jobRecruitPageModel.setPaging(pageModel);

        return new JsonResponse<PageDataModel<JobRecruitEntityExt>>(Constant.STATUS_SUCCESS, jobRecruitPageModel);

    }

}
