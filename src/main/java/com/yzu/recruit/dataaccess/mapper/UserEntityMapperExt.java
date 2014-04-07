package com.yzu.recruit.dataaccess.mapper;

import org.apache.ibatis.annotations.Param;

import com.yzu.recruit.dataaccess.mapper.gen.UserEntityMapper;
import com.yzu.recruit.dataaccess.model.UserEntityExt;


public interface UserEntityMapperExt extends UserEntityMapper{

    int insertUserEntity(UserEntityExt userEntityExt);

    UserEntityExt getBaseUserByName(@Param("userName")String userName);

    UserEntityExt getBaseUserByID(@Param("userID")int userID);

    UserEntityExt getUserByID(@Param("userID")int userID);

    void deleteUserEntityExt(@Param("userID")int userID);

}
