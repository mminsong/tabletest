package com.example.tabletest.Services;

import com.example.tabletest.entities.UserEntity;
import com.example.tabletest.mappers.IUserMapper;
import com.example.tabletest.vos.LoginVo;
import com.example.tabletest.vos.RegisterVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserMapper userMapper;

    @Autowired
    public UserService(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void Login(RegisterVo registerVo){
        if(this.userMapper.insertUser(registerVo) > 0){
            registerVo.setResult("성공");
            return;
        }
        registerVo.setResult("실패");
    }

    public LoginVo loginUser(LoginVo loginVo){
        UserEntity userEntity=this.userMapper.selectUser(loginVo);
        if(userEntity==null){
            loginVo.setResult("실패");
            return loginVo;
        }
        loginVo.setEmail(userEntity.getEmail());
        loginVo.setIndex(userEntity.getIndex());
        loginVo.setPassword(userEntity.getPassword());
        loginVo.setPhoneNumber(userEntity.getPhoneNumber());
        loginVo.setUserName(userEntity.getUserName());
        loginVo.setBirth(userEntity.getBirth());
        loginVo.setResult("성공");
        return loginVo;
    }

    public void insertUser(UserEntity userEntity){this.userMapper.insertUser(userEntity);}

}
