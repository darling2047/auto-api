package com.darling.auto.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/1 15:36
 * @version:
 * @modified By:
 */
@Data
public class ZdApiParamsRulesVo {

    /**
     * 规则id
     */
    @TableId
    private int ruleId;

    /**
     * 适用的参数类型(1:普通字符串:2:对象;3:数组;4:布尔;5:整形)
     */
    private Integer paramType;

    /**
     * 参数类型名称
     */
    private String paramTypeName;

    /**
     * 规则对应的value值
     */
    private String paramValue;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 数组里元素的类型
     */
    private String arrItemType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
