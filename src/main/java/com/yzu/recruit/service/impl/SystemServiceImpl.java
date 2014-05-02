package com.yzu.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.SystemEntityMapperExt;
import com.yzu.recruit.dataaccess.model.SystemEntityExt;
import com.yzu.recruit.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemEntityMapperExt systemEntityMapperExt;

    @Override
    public SystemEntityExt getSystemById(int systemEntityExtID) {
        SystemEntityExt systemEntityExt = systemEntityMapperExt.getSystemById(systemEntityExtID);
        return systemEntityExt;
    }

    @Override
    public void updateSystem(SystemEntityExt systemEntityExt) {
        systemEntityMapperExt.updateSystem(systemEntityExt);
    }

}
