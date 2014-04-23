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
import com.yzu.recruit.common.HandleWebException;
import com.yzu.recruit.common.IHttpStateCode;
import com.yzu.recruit.common.JsonResponse;
import com.yzu.recruit.common.Logger;
import com.yzu.recruit.common.LoggerFactory;
import com.yzu.recruit.dataaccess.model.ExperienceEntityExt;
import com.yzu.recruit.dataaccess.model.UserEntityExt;
import com.yzu.recruit.dataaccess.model.UserInfoEntityExt;
import com.yzu.recruit.service.UserService;
import com.yzu.recruit.web.converter.UserConverter;
import com.yzu.recruit.web.model.UserModel;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> register(HttpServletRequest request, HttpServletResponse response,
            @RequestBody UserEntityExt userEntityExt) {

        try {
             int userID = userService.createUser(userEntityExt);
            HttpSession session = request.getSession();
            UserEntityExt user = userService.getBaseUserByID(userID);
            session.setAttribute("USER", UserConverter.entityToModel(user));

        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }

        response.setStatus(IHttpStateCode.OK);
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> login(HttpServletRequest request, HttpServletResponse response,
            @RequestBody UserEntityExt userEntityExt) {
        String userName = userEntityExt.getName();
        String password = userEntityExt.getPassword();
        try {
            UserEntityExt userEntity = userService.login(userName, password);
            HttpSession session = request.getSession();
            session.setAttribute("USER", UserConverter.entityToModel(userEntity));
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, 1);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS, 0);
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<Integer> logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            response.setStatus(IHttpStateCode.OK);
        } catch (Exception exception) {
            HandleWebException.handleWebException(exception, logger);
        }
        return new JsonResponse<Integer>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse<UserModel> getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        if (null == userModel) {
            response.setStatus(IHttpStateCode.UNAUTHORIZED);
            return null;
        } else {
            response.setStatus(IHttpStateCode.OK);
            return new JsonResponse<UserModel>(Constant.STATUS_SUCCESS, userModel);
        }
    }

    @RequestMapping(value = "/user/saveInfo", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<UserModel> saveUserInfomation(HttpServletRequest request,
            HttpServletResponse response, @RequestBody UserInfoEntityExt userInfoEntityExt) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        userInfoEntityExt.setUserid(userModel.getUserID());
        userService.saveUserInfomation(userInfoEntityExt);
        return new JsonResponse<UserModel>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user/saveExperience", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<UserModel> saveUserExperience(HttpServletRequest request,
            HttpServletResponse response, @RequestBody ExperienceEntityExt experienceEntityExt) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        experienceEntityExt.setUserid(userModel.getUserID());
        userService.saveUserExperience(experienceEntityExt);
        return new JsonResponse<UserModel>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user/saveEducation", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<UserModel> saveUserEducation(HttpServletRequest request,
            HttpServletResponse response, @RequestBody UserEntityExt userEntityExt) {
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("USER");
        userService.saveEducations(userEntityExt.getEducationEntityExtList(), userModel.getUserID());
        return new JsonResponse<UserModel>(Constant.STATUS_SUCCESS);
    }

    @RequestMapping(value = "/user/getResume/{userID}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponse<UserEntityExt> getResumeByUserID(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int userID) {
        UserEntityExt userEntityExt = userService.getUserByID(userID);
        return new JsonResponse<UserEntityExt>(Constant.STATUS_SUCCESS, userEntityExt);
    }
}
