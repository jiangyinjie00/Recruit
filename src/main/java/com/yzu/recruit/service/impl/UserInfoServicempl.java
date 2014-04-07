package com.yzu.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yzu.recruit.dataaccess.mapper.UserInfoEntityMapperExt;
import com.yzu.recruit.dataaccess.model.UserInfoEntityExt;
import com.yzu.recruit.service.UserInfoService;


@Component
public class UserInfoServicempl implements UserInfoService {

    @Autowired
    private UserInfoEntityMapperExt userInfoEntityMapperExt;

    @Override
    public int insertUserInfo(UserInfoEntityExt userInfoEntityExt) {
        return userInfoEntityMapperExt.insertUserInfo(userInfoEntityExt);

    }

    @Override
    public void updateUserInfo(UserInfoEntityExt userInfoEntityExt) {
        userInfoEntityMapperExt.updateUserInfo(userInfoEntityExt);
    }

}
