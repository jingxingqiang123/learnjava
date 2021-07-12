package com.demo.system.user.service.impl;

import com.demo.system.user.mapper.RoleMapper;
import com.demo.system.user.mapper.UserMapper;
import com.demo.system.user.service.RoleService;
import com.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过过角色id查询用户信息
     *
     * @param roleId 角色id
     * @return 用户信息
     */
    @Transactional
    public List<UserEntity> getUserByRoleId(Integer roleId) {
        List<String> userIds = roleMapper.getUserIdsByRoleId(roleId);
        return userMapper.selectBatchIds(userIds);
    }
}
