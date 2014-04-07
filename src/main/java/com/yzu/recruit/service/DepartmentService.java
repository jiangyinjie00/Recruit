package com.yzu.recruit.service;

import com.yzu.recruit.dataaccess.model.DepartmentEntityExt;

public interface DepartmentService {

    public int addDepartment(DepartmentEntityExt departmentEntityExt);

    public DepartmentEntityExt getDepartment(int departmentID);

    public DepartmentEntityExt getDepartmentByUserID(int userID);
}
