package com.darling.auto.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description: 整型参数的测试用例规则枚举
 * @author: dll
 * @date: Created in 2021/11/4 19:39
 * @version:
 * @modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum IntegerCaseRulesEnum {

    INT_28(28,"%s正常入参,如666"),
    INT_29(29,"%s为空-null,如\"null\""),
    INT_30(30,"%s为空-缺失,如该参数不设置"),
    INT_31(31,"%s为int设置string,如\"666\""),
    INT_32(32,"%s为double,如0.66"),
    INT_33(33,"%s为负数,如-666"),
    INT_34(34,"%s为int超过范围,如6666666666");

    private Integer ruleId;

    private String desc;

    public Integer getRuleId() {
        return ruleId;
    }

    public String getDesc() {
        return desc;
    }

}
