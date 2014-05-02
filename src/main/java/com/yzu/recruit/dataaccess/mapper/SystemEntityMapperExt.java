package com.yzu.recruit.dataaccess.mapper;

import com.yzu.recruit.dataaccess.mapper.gen.SystemEntityMapper;
import com.yzu.recruit.dataaccess.model.SystemEntityExt;

public interface SystemEntityMapperExt extends SystemEntityMapper {
    SystemEntityExt getSystemById(int systemEntityExtID);

    void updateSystem(SystemEntityExt systemEntityExt);
}
