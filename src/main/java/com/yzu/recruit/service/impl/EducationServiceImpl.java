package com.yzu.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.recruit.dataaccess.mapper.EducationEntityMapperExt;
import com.yzu.recruit.dataaccess.model.EducationEntityExt;
import com.yzu.recruit.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService{

    @Autowired
    private EducationEntityMapperExt educationEntityMapperExt;

    @Override
    public void insertEducation(List<EducationEntityExt> educationEntityExtList) {
        for (EducationEntityExt educationEntityExt : educationEntityExtList) {
            educationEntityMapperExt.insertEducation(educationEntityExt);
        }

    }

    @Override
    public void updateEducation(List<EducationEntityExt> educationEntityExtList) {
        for (EducationEntityExt educationEntityExt : educationEntityExtList) {
            if (null != educationEntityExt.getEducationid() && educationEntityExt.getEducationid() > 0) {
                if (educationEntityExt.getMarkfordelete() == 0) {
                    educationEntityMapperExt.updateEducation(educationEntityExt);
                } else {
                    educationEntityMapperExt.markForDeleteEducation(educationEntityExt);
                }
            } else {
                educationEntityMapperExt.insertEducation(educationEntityExt);
            }
        }
    }



}
