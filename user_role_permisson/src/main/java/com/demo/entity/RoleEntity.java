package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "T_ROLE")
public class RoleEntity {
    /**
     * 用户id
     */
//    @TableId
    private Integer roleId;

    /**
     * 用户名
     */
    private String roleName;
}