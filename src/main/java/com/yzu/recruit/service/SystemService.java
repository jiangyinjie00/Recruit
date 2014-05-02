package com.yzu.recruit.service;

import com.yzu.recruit.dataaccess.model.SystemEntityExt;

public interface SystemService {
    SystemEntityExt getSystemById(int systemEntityExtID);

    void updateSystem(SystemEntityExt systemEntityExt);
}
