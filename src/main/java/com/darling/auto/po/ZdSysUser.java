package com.darling.auto.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author dll
 * @create 2020/5/29 22:28
 * @describe 用户信息表 DM_SYS_USER
 */
@Data
@TableName("DM_SYS_USER")
public class ZdSysUser {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String deptId;

    private String loginName;

    private String password;

    private String mobile;

    private String email;

    private Date createTime;

    private Date loginTime;

    private Date lastLoginTime;

    private Long count;

    /**
     * 是否删除1:已删除;0:未删除
     */
    private Integer isDelete;

    /**
     * 数据更新时间
     */
    private Date updateTime;

    /**
     * 数据变更时的操作人员
     */
    private String operatorPerson;

}