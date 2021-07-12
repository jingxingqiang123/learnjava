package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "T_USER")
public class UserEntity {
    /**
     * 用户id
     */
    @TableId
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 密码修改时间
     */
    private Long modifyTime;

    /**
     * 用户描述信息
     */
    private String description;
}

