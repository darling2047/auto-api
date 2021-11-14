package com.darling.auto.utils;

import com.darling.auto.constant.StrCaseRulesEnum;

import java.util.Objects;

/**
 * @description: 接口参数生产工具类
 * @author: dll
 * @date: Created in 2021/11/9 11:43
 * @version:
 * @modified By:
 */
public class ApiParamValueProdcutUtils {

    /**
     * 根据规则id获取接口value值
     * @param ruleId
     * @param paramValue
     * @return
     */
    public static Object getValueByRuleId(Integer ruleId,String paramValue) {
        Object res = "";
        if (Objects.equals(StrCaseRulesEnum.EMPTY_STR.getRuleId(),ruleId)) {
            res = " ";
        }else if (Objects.equals(StrCaseRulesEnum.NORMAL_EMPTY_STR.getRuleId(),ruleId)) {
            res = "";
        }else if (Objects.equals(StrCaseRulesEnum.BEFORE_EMPTY.getRuleId(),ruleId)) {
            res = " " + paramValue;
        }else if (Objects.equals(StrCaseRulesEnum.AFTER_EMPTY.getRuleId(),ruleId)) {
            res = paramValue + " ";
        }else if (Objects.equals(StrCaseRulesEnum.BEFORE_AFTER_EMPTY.getRuleId(),ruleId)) {
            res = " " + paramValue + " ";
        }else if (Objects.equals(StrCaseRulesEnum.MIDDLE_EMPTY.getRuleId(),ruleId)) {
            char[] chars = paramValue.toCharArray();
            String pra = "";
            for (int i = 0; i < chars.length; i++) {
                pra += chars[i];
                if (i == 1) {
                    pra+=" ";
                }
            }
            res = pra;
        }else if (Objects.equals(StrCaseRulesEnum.SPECIAL_CHARACTER.getRuleId(),ruleId)) {
            res = "&*&^" + paramValue + "@!";
        }else if (Objects.equals(StrCaseRulesEnum.OVER_LENGTH.getRuleId(),ruleId)) {
            res = "wdwswswswswwswswswswsswsw" + paramValue + "wswswswwsw";
        }else if (Objects.equals(StrCaseRulesEnum.NULL_STR.getRuleId(),ruleId)) {
            res = "null";
        }else {
            res = paramValue;
        }
        return res;
    }

}
