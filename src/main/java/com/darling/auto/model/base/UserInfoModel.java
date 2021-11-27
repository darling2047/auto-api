package com.darling.auto.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author dll
 * @create 2020/5/30 09:53
 * @describe 用户信息 MODEL
 */
@Data
public class UserInfoModel extends PageBaseModel{

    /**
     * 角色id
     */
    private List<String> roleIds;

    /**
     * 新增(add)或修改(edit)标识
     */
    private String updateFlag;

    private Integer userId;

    private String userName;

    private String deptId;

    private String loginName;

    private String mobile;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Date loginTime;

    private Date lastLoginTime;

    private Long count;

    private String deptName;


    /**
     * 数据更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 数据变更时的操作人员
     */
    private String operatorPerson;

    private String password;

}