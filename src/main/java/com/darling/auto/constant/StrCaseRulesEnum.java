package com.darling.auto.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description: 字符串类型参数的测试用例规则枚举
 * @author: dll
 * @date: Created in 2021/11/4 19:39
 * @version:
 * @modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum StrCaseRulesEnum {

    NORMAL_EMPTY_STR(1,"空字符串，如“”"),
    NULL_STR(2,"等于null"),
    EMPTY_STR(3,"等于空字符串,如\" \""),
    BEFORE_EMPTY(5,"前后含空格-前，如' 张三'"),
    AFTER_EMPTY(6,"前后含空格-后，如'张三 '"),
    BEFORE_AFTER_EMPTY(7,"前后含空格-前后，如' 张三 '"),
    MIDDLE_EMPTY(8,"中间含空格，如'张 三'"),
    SPECIAL_CHARACTER(9,"含特殊字符，如'%￥#name'"),
    OVER_LENGTH(10,"超长"),
    NORMAL_STR(4,"正常参数");

    private Integer ruleId;

    private String desc;

    public Integer getRuleId() {
        return ruleId;
    }

    public String getDesc() {
        return desc;
    }

}
