package com.yzu.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yzu.recruit.dataaccess.mapper.ExperienceEntityMapperExt;
import com.yzu.recruit.service.ExperienceService;

@Component
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceEntityMapperExt experienceEntityMapperExt;

}
