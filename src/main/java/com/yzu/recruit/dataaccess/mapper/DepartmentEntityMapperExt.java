package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.DepartmentEntityMapper;
import com.yzu.recruit.dataaccess.model.DepartmentEntityExt;

public interface DepartmentEntityMapperExt extends DepartmentEntityMapper {

    int saveDepartment(DepartmentEntityExt departmentEntityExt);

    DepartmentEntityExt getDepartment(int departmentID);

    DepartmentEntityExt getDepartmentByUserID(@Param("userID")int userID);

}
