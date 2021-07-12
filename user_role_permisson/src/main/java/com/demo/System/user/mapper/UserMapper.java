package com.demo.System.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<UserEntity> {
//    @Insert("insert into T_USER_R_ROLE (user_id,role_id) values (#{userId},#{roleId})")
    void insertUserRole(@Param("userId") String userId, @Param("roleId")Integer roleId);
}
