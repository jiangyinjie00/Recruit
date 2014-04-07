package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.EducationEntityMapper;
import com.yzu.recruit.dataaccess.model.EducationEntityExt;

public interface EducationEntityMapperExt extends EducationEntityMapper {

    int insertEducation(EducationEntityExt educationEntityExt);

    void updateEducation(EducationEntityExt educationEntityExt);

    void markForDeleteEducation(EducationEntityExt educationEntityExt);

	void deleteEducation(@Param("educationid") Integer educationid);

}
