package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.dataaccess.model.EducationEntityExt;
import com.yzu.recruit.dataaccess.model.ExperienceEntityExt;
import com.yzu.recruit.dataaccess.model.UserEntityExt;
import com.yzu.recruit.dataaccess.model.UserInfoEntityExt;

public interface UserService {
    UserEntityExt login(String userName, String password);

    int createUser(UserEntityExt userEntityExt);

    UserEntityExt getBaseUserByID(int userID);

    void saveUserInfomation(UserInfoEntityExt userInfoEntityExt);

    void saveUserExperience(ExperienceEntityExt experienceEntityExt);

    void saveEducations(List<EducationEntityExt> educationEntityExtList, int userID);

    UserEntityExt getUserByID(int userID);
}
