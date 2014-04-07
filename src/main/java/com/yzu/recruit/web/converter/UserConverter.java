package com.yzu.recruit.web.converter;

import com.yzu.recruit.dataaccess.model.UserEntityExt;
import com.yzu.recruit.web.model.UserModel;

public class UserConverter {
    public static UserModel entityToModel(UserEntityExt userEntityExt) {
        UserModel user = new UserModel();
        user.setUserID(userEntityExt.getUserid());
        user.setUsername(userEntityExt.getName());
        user.setRoleID(userEntityExt.getRoleid());
        user.setLastLoginDate(userEntityExt.getLastlogindate());

        return user;
    }
}
