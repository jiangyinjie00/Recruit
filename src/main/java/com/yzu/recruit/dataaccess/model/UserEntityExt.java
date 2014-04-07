package com.yzu.recruit.dataaccess.model;

import java.util.List;

import com.yzu.recruit.dataaccess.model.gen.UserEntity;

public class UserEntityExt extends UserEntity {
    private UserInfoEntityExt userInfoEntityExt;
    private List<EducationEntityExt> educationEntityExtList;
    private ExperienceEntityExt experienceEntityExt;

    public UserInfoEntityExt getUserInfoEntityExt() {
        return userInfoEntityExt;
    }

    public void setUserInfoEntityExt(UserInfoEntityExt userInfoEntityExt) {
        this.userInfoEntityExt = userInfoEntityExt;
    }

    public List<EducationEntityExt> getEducationEntityExtList() {
        return educationEntityExtList;
    }

    public void setEducationEntityExtList(List<EducationEntityExt> educationEntityExtList) {
        this.educationEntityExtList = educationEntityExtList;
    }

    public ExperienceEntityExt getExperienceEntityExt() {
        return experienceEntityExt;
    }

    public void setExperienceEntityExt(ExperienceEntityExt experienceEntityExt) {
        this.experienceEntityExt = experienceEntityExt;
    }

}
