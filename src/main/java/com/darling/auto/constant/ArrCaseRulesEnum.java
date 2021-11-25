package com.darling.auto.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description: 数组参数的测试用例规则枚举
 * @author: dll
 * @date: Created in 2021/11/4 19:39
 * @version:
 * @modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ArrCaseRulesEnum {

    ARR_38(38,"%s正常入参"),
    ARR_39(39,"%s为空-[]"),
    ARR_40(40,"%s为空-null"),
    ARR_41(41,"%s为空-[  ]"),
    ARR_42(42,"%s为空-缺失"),
    ARR_43(43,"%s单个值含空格-前"),
    ARR_44(44,"%s单个值含空格-后"),
    ARR_45(45,"%s单个值含空格-前后"),
    ARR_46(46,"%s单个值含特殊字符"),
    ARR_47(47,"%s设置单个值"),
    ARR_48(48,"%s数组长度不变,其中一个元素设置错误的值"),
    ARR_49(49,"%s超长");

    private Integer ruleId;

    private String desc;

    public Integer getRuleId() {
        return ruleId;
    }

    public String getDesc() {
        return desc;
    }

}
