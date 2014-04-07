package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.UserInfoEntityMapper;
import com.yzu.recruit.dataaccess.model.ExperienceEntityExt;
import com.yzu.recruit.dataaccess.model.UserInfoEntityExt;


public interface UserInfoEntityMapperExt extends UserInfoEntityMapper {

    int insertUserInfo(UserInfoEntityExt userInfoEntityExt);

    void updateUserInfo(UserInfoEntityExt userInfoEntityExt);

    UserInfoEntityExt getUserInfoByUserID(@Param("userID") int userID);

    void updateExperience(ExperienceEntityExt experienceEntityExt);
}
