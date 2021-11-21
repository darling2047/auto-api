package com.darling.auto.service.impl;

import com.darling.auto.annotation.ApiValueProductCase;
import com.darling.auto.constant.IntegerCaseRulesEnum;
import com.darling.auto.service.ZdhApiValueProductService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Objects;

/**
 * @description: 接口参数是整型的测试用例生成
 * @author: dll
 * @date: Created in 2021/11/14 20:02
 * @version:
 * @modified By:
 */
@Service
@ApiValueProductCase(5)
public class ZdhApiValueIntegerProductServiceImpl implements ZdhApiValueProductService {


    @Override
    public Object getValueByRuleId(Integer ruleId, Object paramValue) {
        if (Objects.equals(IntegerCaseRulesEnum.INT_28.getRuleId(),ruleId)) {
            return 666;
        }else if (Objects.equals(IntegerCaseRulesEnum.INT_29.getRuleId(),ruleId)) {
            return "null";
        }else if (Objects.equals(IntegerCaseRulesEnum.INT_30.getRuleId(),ruleId)) {
            // 返回null jsonObject不会set该key，会有缺失的效果
            return null;
        }else if (Objects.equals(IntegerCaseRulesEnum.INT_31.getRuleId(),ruleId)) {
            return "666";
        }else if (Objects.equals(IntegerCaseRulesEnum.INT_32.getRuleId(),ruleId)) {
            return 0.66;
        }else if (Objects.equals(IntegerCaseRulesEnum.INT_33.getRuleId(),ruleId)) {
            return -666;
        }else if (Objects.equals(IntegerCaseRulesEnum.INT_34.getRuleId(),ruleId)) {
            return new BigInteger("666666666666");
        }else {
            return paramValue;
        }
}
}
