package com.darling.auto.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description: 对象参数的测试用例规则枚举
 * @author: dll
 * @date: Created in 2021/11/4 19:39
 * @version:
 * @modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ObjCaseRulesEnum {

    INT_35(35,"%s正常入参"),
    INT_36(36,"%s为空-缺失,如该参数不设置"),
    INT_37(37,"%s设置一个keyvalue");

    private Integer ruleId;

    private String desc;

    public Integer getRuleId() {
        return ruleId;
    }

    public String getDesc() {
        return desc;
    }

}
