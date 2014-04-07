package com.yzu.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.DepartmentEntityMapperExt;
import com.yzu.recruit.dataaccess.model.DepartmentEntityExt;
import com.yzu.recruit.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentEntityMapperExt departmentEntityMapperExt;

    @Override
    public int addDepartment(DepartmentEntityExt departmentEntityExt) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public DepartmentEntityExt getDepartment(int departmentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DepartmentEntityExt getDepartmentByUserID(int userID) {
        return departmentEntityMapperExt.getDepartmentByUserID(userID);
    }


}
