package com.demo.system.user.service;

import com.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUser();

    void createUser(UserEntity userEntity);
}
