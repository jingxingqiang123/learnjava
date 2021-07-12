package com.demo.System.user.service;

import com.demo.entity.UserEntity;

import java.util.List;

public interface RoleService {
    List<UserEntity> getUserByRoleId(Integer roleId);
}
