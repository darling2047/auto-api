package com.darling.auto.service.impl;

import com.darling.auto.annotation.ApiValueProductCase;
import com.darling.auto.constant.StrCaseRulesEnum;
import com.darling.auto.service.ZdhApiValueProductService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @description: 接口参数是字符串类型的测试用例生成
 * @author: dll
 * @date: Created in 2021/11/14 20:00
 * @version:
 * @modified By:
 */
@Service
@ApiValueProductCase(1)
public class ZdhApiValueStrProductServiceImpl implements ZdhApiValueProductService {


    @Override
    public Object getValueByRuleId(Integer ruleId, Object paramValue) {
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
            char[] chars = paramValue.toString().toCharArray();
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
