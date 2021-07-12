package com.demo.system.user.controller;

import com.demo.system.user.service.RoleService;
import com.demo.aspect.RightsController;
import com.demo.common.constant.RoleConstant;
import com.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 通过角色id查询所有的用户信息
     *
     * @param roleId 角色id
     * @return 用户信息
     */
    @GetMapping("/getUserByRoleId")
    @RightsController(role = {RoleConstant.ADMIN_ROLE, RoleConstant.SHENJI_ROLE})
    public List<UserEntity> getUserByRoleId(@RequestParam("roleId") Integer roleId) {
        return roleService.getUserByRoleId(roleId);
    }
}
