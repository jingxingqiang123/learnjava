package com.demo.System.user.controller;

import com.demo.System.user.service.UserService;
import com.demo.aspect.RightsController;
import com.demo.common.constant.RoleConstant;
import com.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 获取所有的用户
     *
     * @return 所有用户
     */
    @GetMapping("/getAllUser")
    @RightsController(role = {RoleConstant.ADMIN_ROLE, RoleConstant.SHENJI_ROLE})
    public List<UserEntity> getAllUser() {
        return userService.getAllUser();
    }
    /**
     * 创建用户
     *
     * @return 所有用户
     */
    @PostMapping("/createUser")
    @RightsController(role = { RoleConstant.ADMIN_ROLE})
    public void createUser(UserEntity userEntity) {
         userService.createUser(userEntity);
    }
}
