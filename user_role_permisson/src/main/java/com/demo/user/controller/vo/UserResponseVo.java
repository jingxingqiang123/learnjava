package com.demo.user.controller.vo;

import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Getter
@Setter
public class UserResponseVo {
    List<UserEntity> userList;
    List<RoleEntity> roleEntityList;
}
