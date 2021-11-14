package com.darling.auto.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description: 布尔类型参数的测试用例规则枚举
 * @author: dll
 * @date: Created in 2021/11/4 19:39
 * @version:
 * @modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum BoolCaseRulesEnum {

    BOOL_11(11,"正常输入,如“iskey”：false"),
    BOOL_12(12,"为\"false\",如“iskey”：\"false\""),
    BOOL_14(14,"%s为\"False\",如“iskey”：\"False\""),
    BOOL_15(15,"%s为0,如“iskey”：0"),
    BOOL_16(16,"%s为\"0\",如“iskey”：\"0\""),
    BOOL_17(17,"%s正常输入,如“iskey”：true"),
    BOOL_18(18,"%s为\"true\",如“iskey”：\"true\""),
    BOOL_20(20,"%s为\"True\",如“iskey”：\"True\""),
    BOOL_21(21,"%s为1,如“iskey”：1"),
    BOOL_22(22,"%s为\"1\",如“iskey”：\"1\""),
    BOOL_23(23,"%s为错误值2,如“iskey”：\"2\""),
    BOOL_24(24,"%s含特殊字符%,如“iskey”：true%"),
    BOOL_25(25,"%s为空-null,如“iskey”：null"),
    BOOL_26(26,"%s为空-“”,如“iskey”：\"\""),
    BOOL_27(27,"%s为空-缺失,如该参数不设置");

    private Integer ruleId;

    private String desc;

    public Integer getRuleId() {
        return ruleId;
    }

    public String getDesc() {
        return desc;
    }

}
