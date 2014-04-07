package com.yzu.recruit.service;

import com.yzu.recruit.dataaccess.model.UserInfoEntityExt;

public interface UserInfoService {

    int insertUserInfo(UserInfoEntityExt userInfoEntityExt);

    void updateUserInfo(UserInfoEntityExt userInfoEntityExt);
}
