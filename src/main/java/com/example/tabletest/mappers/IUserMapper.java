package com.example.tabletest.mappers;

import com.example.tabletest.entities.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper { //인터페이스 이용해서 DB와 연결
    int insertUser(UserEntity userEntity);
    UserEntity selectUser(UserEntity userEntity);
}
