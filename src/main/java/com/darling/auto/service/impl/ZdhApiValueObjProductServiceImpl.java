package com.darling.auto.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.darling.auto.annotation.ApiValueProductCase;
import com.darling.auto.constant.IntegerCaseRulesEnum;
import com.darling.auto.constant.ObjCaseRulesEnum;
import com.darling.auto.service.ZdhApiValueProductService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

/**
 * @description: 接口参数是对象类型的测试用例生成
 * @author: dll
 * @date: Created in 2021/11/14 20:02
 * @version:
 * @modified By:
 */
@Service
@ApiValueProductCase(2)
public class ZdhApiValueObjProductServiceImpl implements ZdhApiValueProductService {


    @Override
    public Object getValueByRuleId(Integer ruleId, Object paramValue) {
        if (Objects.equals(ObjCaseRulesEnum.INT_35.getRuleId(), ruleId)) {
            return paramValue;
        } else if (Objects.equals(ObjCaseRulesEnum.INT_36.getRuleId(), ruleId)) {
            return null;
        } else if (Objects.equals(ObjCaseRulesEnum.INT_37.getRuleId(), ruleId)) {
            JSONObject tempJson = getTempJSON(JSONObject.parseObject(paramValue.toString()));
            return tempJson;
        }
        return paramValue;
    }

    /**
     * 获取json对象中随机一个key组成新对象返回
     * @param json
     * @return
     */
    private JSONObject getTempJSON(JSONObject json) {
        JSONObject tempJson = new JSONObject();
        Set<String> keySet = json.keySet();
        for (String key : keySet) {
            tempJson.put(key,json.get(key));
            break;
        }
        return tempJson;
    }
}
