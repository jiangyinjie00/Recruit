package com.yzu.recruit.dataaccess.model;

import com.yzu.recruit.dataaccess.model.gen.DepartmentEntity;

public class DepartmentEntityExt extends DepartmentEntity {
    private UserEntityExt userEntityExt;

    public UserEntityExt getUserEntityExt() {
        return userEntityExt;
    }
    
    public void setUserEntityExt(UserEntityExt userEntityExt) {
        this.userEntityExt = userEntityExt;
    }

}
