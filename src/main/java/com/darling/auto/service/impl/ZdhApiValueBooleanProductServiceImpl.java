package com.darling.auto.service.impl;

import com.darling.auto.annotation.ApiValueProductCase;
import com.darling.auto.constant.BoolCaseRulesEnum;
import com.darling.auto.service.ZdhApiValueProductService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @description: 接口参数是布尔类型的测试用例生成
 * @author: dll
 * @date: Created in 2021/11/14 20:02
 * @version:
 * @modified By:
 */
@Service
@ApiValueProductCase(4)
public class ZdhApiValueBooleanProductServiceImpl implements ZdhApiValueProductService {


    @Override
    public Object getValueByRuleId(Integer ruleId, String paramValue) {
        Object res = "";
        if (Objects.equals(BoolCaseRulesEnum.BOOL_11.getRuleId(),ruleId)) {
            return false;
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_12.getRuleId(),ruleId)) {
            return "false";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_14.getRuleId(),ruleId)) {
            return "False";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_15.getRuleId(),ruleId)) {
            return 0;
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_16.getRuleId(),ruleId)) {
            return "0";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_17.getRuleId(),ruleId)) {
            return true;
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_18.getRuleId(),ruleId)) {
            return "true";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_20.getRuleId(),ruleId)) {
            return "True";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_21.getRuleId(),ruleId)) {
            return 1;
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_22.getRuleId(),ruleId)) {
            return "1";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_23.getRuleId(),ruleId)) {
            return "2";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_24.getRuleId(),ruleId)) {
            return "true#";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_25.getRuleId(),ruleId)) {
            return "null";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_26.getRuleId(),ruleId)) {
            return "";
        }else if (Objects.equals(BoolCaseRulesEnum.BOOL_27.getRuleId(),ruleId)) {
            return null;
        }else {
            return paramValue;
        }
}
}
