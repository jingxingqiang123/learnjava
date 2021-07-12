package com.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleEntity> {
    @Select("Select user_id  from T_USER_R_ROLE where role_id = #{roleId}")
    List<String> getUserIdsByRoleId(@Param("roleId") Integer roleId);

}
