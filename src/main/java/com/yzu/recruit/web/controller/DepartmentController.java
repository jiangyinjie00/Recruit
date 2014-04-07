package com.yzu.recruit.web.controller;

import org.springframework.web.bind.annotation.PathVariable;

import com.yzu.recruit.dataaccess.model.DepartmentEntityExt;
import com.yzu.recruit.service.DepartmentService;


public class DepartmentController {
    // @Autowired
    private DepartmentService departmentService;

    // @RequestMapping()
    public int addDepartment(@PathVariable DepartmentEntityExt departmentEntityExt) {
        int departmentID = departmentService.addDepartment(departmentEntityExt);
        return departmentID;
    }

    // @RequestMapping
    public DepartmentEntityExt getDepartment(@PathVariable int departmentID) {
        return departmentService.getDepartment(departmentID);
    }
}
