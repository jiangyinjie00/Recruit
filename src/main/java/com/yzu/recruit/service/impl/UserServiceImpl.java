package com.yzu.recruit.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yzu.recruit.common.Constant;
import com.yzu.recruit.common.ErrorCode;
import com.yzu.recruit.common.Logger;
import com.yzu.recruit.common.LoggerFactory;
import com.yzu.recruit.dataaccess.mapper.EducationEntityMapperExt;
import com.yzu.recruit.dataaccess.mapper.ExperienceEntityMapperExt;
import com.yzu.recruit.dataaccess.mapper.UserEntityMapperExt;
import com.yzu.recruit.dataaccess.mapper.UserInfoEntityMapperExt;
import com.yzu.recruit.dataaccess.model.EducationEntityExt;
import com.yzu.recruit.dataaccess.model.ExperienceEntityExt;
import com.yzu.recruit.dataaccess.model.UserEntityExt;
import com.yzu.recruit.dataaccess.model.UserInfoEntityExt;
import com.yzu.recruit.exception.ArgumentException;
import com.yzu.recruit.service.UserService;
import com.yzu.recruit.util.EncryptionUtil;
import com.yzu.recruit.util.StringUtil;

@Component
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserEntityMapperExt userEntityMapperExt;

    @Autowired
    private UserInfoEntityMapperExt userInfoEntityMapperExt;

    @Autowired
    private ExperienceEntityMapperExt experienceEntityMapperExt;

    @Autowired
    private EducationEntityMapperExt educationEntityMapperExt;

    @Override
    public UserEntityExt login(String userName, String password) {

        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
            String errorMessage = "user name or password can not be empty";
            int errorCode = ErrorCode.USER_NAME_EMPTY_ERROR;
            logger.warn(errorMessage, errorCode);
            throw new ArgumentException(errorMessage, errorCode);
        }

        UserEntityExt userEntityExt = userEntityMapperExt.getBaseUserByName(userName);

        // !EncryptionUtil.checkText(userName, userEntityExt.getPassword())
        if (userEntityExt == null) {
            String errorMessage = "user name or password is wrong";
            int errorCode = ErrorCode.USER_NAME_PASSWORD_ERROR;
            logger.warn(errorMessage, errorCode);
            throw new ArgumentException(errorMessage, errorCode);
        }
        return userEntityExt;
    }

    @Override
    public int createUser(UserEntityExt userEntityExt) {
        userEntityExt.setRegisterdate(new Date());
        userEntityExt.setRoleid(Constant.ROLE_USER);
        userEntityExt.setPassword(EncryptionUtil.encrypt(userEntityExt.getPassword()));
        userEntityMapperExt.insertUserEntity(userEntityExt);
        return userEntityExt.getUserid();
    }

    @Override
    public UserEntityExt getBaseUserByID(int userID) {
        return userEntityMapperExt.getBaseUserByID(userID);
    }

    @Override
    public void saveUserInfomation(UserInfoEntityExt userInfoEntityExt) {
        int userID = userInfoEntityExt.getUserid();
        UserInfoEntityExt userInfo = userInfoEntityMapperExt.getUserInfoByUserID(userID);
        if (userInfo == null) {
            userInfoEntityMapperExt.insertUserInfo(userInfoEntityExt);
        } else {
            userInfoEntityExt.setUserinfoid(userInfo.getUserinfoid());
            userInfoEntityMapperExt.updateUserInfo(userInfoEntityExt);
        }

    }

    @Override
    public void saveUserExperience(ExperienceEntityExt experienceEntityExt) {
        int userID = experienceEntityExt.getUserid();
        ExperienceEntityExt experience = experienceEntityMapperExt.getExperienceByUserID(userID);
        if (experience == null) {
            experienceEntityMapperExt.insertExperience(experienceEntityExt);
        } else {
            experienceEntityExt.setExperienceid(experience.getExperienceid());
            userInfoEntityMapperExt.updateExperience(experienceEntityExt);
        }
    }

    @Override
    public void saveEducations(List<EducationEntityExt> educationEntityExtList, int userID) {

        for (EducationEntityExt educationEntityExt : educationEntityExtList) {
            if (educationEntityExt.getEducationid() == null) {
                educationEntityExt.setUserid(userID);
                educationEntityMapperExt.insertEducation(educationEntityExt);
            } else {
                if (educationEntityExt.getMarkfordelete() == 1) {
                    educationEntityMapperExt.deleteEducation(educationEntityExt.getEducationid());
                } else {
                    educationEntityMapperExt.updateEducation(educationEntityExt);
                }
            }

        }
    }

    @Override
    public UserEntityExt getUserByID(int userID) {
        return userEntityMapperExt.getUserByID(userID);
    }

}
