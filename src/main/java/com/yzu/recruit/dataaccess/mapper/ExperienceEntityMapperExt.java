package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.ExperienceEntityMapper;
import com.yzu.recruit.dataaccess.model.ExperienceEntityExt;

public interface ExperienceEntityMapperExt extends ExperienceEntityMapper {

    int insertExperience(ExperienceEntityExt experienceEntityExt);

    void updateExperience(ExperienceEntityExt experienceEntityExt);

    ExperienceEntityExt getExperienceByUserID(@Param("userID")int userID);

    ExperienceEntityExt getExperienceByID(@Param("experienceID")int experienceID);

}
