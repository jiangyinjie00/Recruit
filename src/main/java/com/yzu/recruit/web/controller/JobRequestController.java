package com.yzu.recruit.web.controller;

import java.util.List;

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
import com.yzu.recruit.common.pagination.PageDataModel;
import com.yzu.recruit.common.pagination.PageModel;
import com.yzu.recruit.common.pagination.Pagination;
import com.yzu.recruit.dataaccess.model.DepartmentEntityExt;
import com.yzu.recruit.dataaccess.model.JobRequestEntityExt;
import com.yzu.recruit.service.DepartmentService;
import com.yzu.recruit.service.JobRequestService;
import com.yzu.recruit.web.converter.CriteriaConverter;
import com.yzu.recruit.web.model.Audition;
import com.yzu.recruit.web.model.Operation;
import com.yzu.recruit.web.model.RequestQueryVo;
import com.yzu.recruit.web.model.UserModel;

@Controller
public class JobRequestController {

    @Autowired
    private JobRequestService jobRequestService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/job/createJobRequest", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> createJobRequest(HttpServletRequest request,
            HttpServletResponse response, @RequestBody int jobRecruitID) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        int jobRequestID = jobRequestService.createJobRequest(jobRecruitID, userModel.getUserID());
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, jobRequestID);

    }

    @RequestMapping(value = "/job/jobRequests", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PageDataModel<JobRequestEntityExt>> getJobRequests(HttpServletRequest request,
            HttpServletResponse response, @RequestBody RequestQueryVo requestQueryVo) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        int roleID = userModel.getRoleID();
        int departmentID;
        int statusID;
        if (roleID == Constant.ROLE_DEPARTMENT) {
            DepartmentEntityExt department = departmentService.getDepartmentByUserID(userModel.getUserID());
            departmentID = department.getDepartmentid();
            statusID = Constant.STATUS_NEW;
        } else {
            if (roleID == Constant.ROLE_HR) {
                statusID = Constant.STATUS_DEPARTMENTAPPROVE;
            } else {
                statusID = Constant.STATUS_HRAPPROVE;
            }
            departmentID = 0;
        }

        Pagination pagination = CriteriaConverter.toPagination(requestQueryVo.getPageModel());
        List<JobRequestEntityExt> list = jobRequestService.queryJobRequestByCriteria(departmentID, statusID, pagination);

        int count = jobRequestService.queryAllJobRequestByCriteria(departmentID, statusID);
        PageModel pageModel = requestQueryVo.getPageModel();
        pageModel.setRowCount(count);

        PageDataModel<JobRequestEntityExt> pageDataModel = new PageDataModel<JobRequestEntityExt>();
        pageDataModel.setData(list);
        pageDataModel.setPaging(pageModel);
        return new JsonResponse<PageDataModel<JobRequestEntityExt>>(Constant.STATUS_SUCCESS, pageDataModel);

    }

    @RequestMapping(value = "/job/auditionJobRequests", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PageDataModel<JobRequestEntityExt>> getAuditionJobRequests(HttpServletRequest request,
            HttpServletResponse response, @RequestBody RequestQueryVo requestQueryVo) {
        Pagination pagination = CriteriaConverter.toPagination(requestQueryVo.getPageModel());
        List<JobRequestEntityExt> list = jobRequestService.queryAuditionJobRequest(pagination);

        int count = jobRequestService.queryAllAuditionJobRequest();
        PageModel pageModel = requestQueryVo.getPageModel();
        pageModel.setRowCount(count);

        PageDataModel<JobRequestEntityExt> pageDataModel = new PageDataModel<JobRequestEntityExt>();
        pageDataModel.setData(list);
        pageDataModel.setPaging(pageModel);
        return new JsonResponse<PageDataModel<JobRequestEntityExt>>(Constant.STATUS_SUCCESS, pageDataModel);

    }

    @RequestMapping(value = "/job/ownJobRequests", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<PageDataModel<JobRequestEntityExt>> getOwnJobRequests(HttpServletRequest request,
            HttpServletResponse response, @RequestBody RequestQueryVo requestQueryVo) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        int userID = userModel.getUserID();
        Pagination pagination = CriteriaConverter.toPagination(requestQueryVo.getPageModel());

        List<JobRequestEntityExt> list = jobRequestService.queryOwnJobRequests(userID, pagination);
        int count = jobRequestService.queryAllOwnJobRequests(userID);

        PageModel pageModel = requestQueryVo.getPageModel();
        pageModel.setRowCount(count);

        PageDataModel<JobRequestEntityExt> pageDataModel = new PageDataModel<JobRequestEntityExt>();
        pageDataModel.setData(list);
        pageDataModel.setPaging(pageModel);
        return new JsonResponse<PageDataModel<JobRequestEntityExt>>(Constant.STATUS_SUCCESS, pageDataModel);

    }

    @RequestMapping(value = "/job/requestDetail/{jobRequestID}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<JobRequestEntityExt> getRequestByID(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int jobRequestID) {

        JobRequestEntityExt jobRequestEntityExt = jobRequestService.getJobRequestByID(jobRequestID);

        return new JsonResponse<JobRequestEntityExt>(Constant.STATUS_SUCCESS, jobRequestEntityExt);

    }

    @RequestMapping(value = "/job/requestStatusChange", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> requestStatusChange(HttpServletRequest request,
            HttpServletResponse response, @RequestBody Operation operation) {

        jobRequestService.updateJobRequestStatus(operation.getOpinion(), operation.getStatusID(), operation.getJobRequestID());

        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, 1);

    }

    @RequestMapping(value = "/job/auditionResponse", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> auditionResponse(HttpServletRequest request,
            HttpServletResponse response, @RequestBody Operation operation) {

        jobRequestService.updateAuditionResponse(operation.getOpinion(), operation.getJobRequestID());

        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, 1);

    }

    @RequestMapping(value = "/job/audition", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> audition(HttpServletRequest request,
            HttpServletResponse response, @RequestBody Audition audition) {

        jobRequestService.releaseAudition(audition.getAuditionInfo(), audition.getAuditionTime(), audition.getJobRequestArrary());

        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, 1);

    }
}
