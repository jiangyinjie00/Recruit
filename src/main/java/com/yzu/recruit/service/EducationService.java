package com.yzu.recruit.service;

import java.util.List;

import com.yzu.recruit.dataaccess.model.EducationEntityExt;

public interface EducationService {

    void insertEducation(List<EducationEntityExt> educationEntityExtList);

    void updateEducation(List<EducationEntityExt> educationEntityExtList);

}
