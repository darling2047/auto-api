package com.darling.auto.constant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * @description: 规则类型的枚举
 * @author: dll
 * @date: Created in 2021/11/4 19:39
 * @version:
 * @modified By:
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ParamTypeEnum {

    STR(1,"普通字符串"),
    OBJECT(2,"json对象"),
    ARRAY(3,"json数组"),
    BOOLEAN(4,"布尔类型"),
    INTEGER(5,"整形");

    private Integer paramType;

    private String desc;

    public Integer getRuleId() {
        return paramType;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByParamType (Integer paramType) {
        return Arrays.stream(ParamTypeEnum.values())
                .filter(type -> Objects.equals(type.getRuleId(), paramType))
                .findFirst().get().desc;
    }

}
