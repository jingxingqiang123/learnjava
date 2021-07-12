package com.demo.system.user.service.impl;

import com.demo.system.user.mapper.UserMapper;
import com.demo.system.user.service.UserService;
import com.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public List<UserEntity> getAllUser() {
        return userMapper.selectList(null);
    }

    public void createUser(UserEntity userEntity) {
        String userId = UUID.randomUUID().toString().replaceAll("-","");
        userEntity.setUserId(userId);
        // 用户表
        userMapper.insert(userEntity);
        // 用户角色表
        userMapper.insertUserRole(userId, userEntity.getRoleId());
    }

}
