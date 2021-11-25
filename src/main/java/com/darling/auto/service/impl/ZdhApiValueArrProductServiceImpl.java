package com.darling.auto.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.darling.auto.annotation.ApiValueProductCase;
import com.darling.auto.constant.ArrCaseRulesEnum;
import com.darling.auto.constant.ObjCaseRulesEnum;
import com.darling.auto.service.ZdhApiValueProductService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

/**
 * @description: 接口参数是数组类型的测试用例生成
 * @author: dll
 * @date: Created in 2021/11/14 20:02
 * @version:
 * @modified By:
 */
@Service
@ApiValueProductCase(3)
public class ZdhApiValueArrProductServiceImpl implements ZdhApiValueProductService {


    @Override
    public Object getValueByRuleId(Integer ruleId, Object paramValue) {
        JSONArray array = JSONArray.parseArray(paramValue.toString());
        if (Objects.equals(ArrCaseRulesEnum.ARR_38.getRuleId(), ruleId)) {
            return paramValue;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_39.getRuleId(), ruleId)) {
            return new JSONArray();
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_40.getRuleId(), ruleId)) {
            // TODO  %s为空-null,目前先返回字符串null,后续优化
            return "null";
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_41.getRuleId(), ruleId)) {
            // TODO %s为空-[  ]暂不支持,后续优化
            return paramValue;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_42.getRuleId(), ruleId)) {
            return null;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_43.getRuleId(), ruleId)) {
            JSONArray tempArr = getTempRuleARR(array,1);
            return tempArr;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_44.getRuleId(), ruleId)) {
            JSONArray tempArr = getTempRuleARR(array,2);
            return tempArr;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_45.getRuleId(), ruleId)) {
            JSONArray tempArr = getTempRuleARR(array,3);
            return tempArr;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_46.getRuleId(), ruleId)) {
            JSONArray tempArr = getTempRuleARR(array,4);
            return tempArr;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_47.getRuleId(), ruleId)) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(array.get(0));
            return jsonArray;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_48.getRuleId(), ruleId)) {
            // TODO 需要考虑数组元素非字符串的情况
            JSONArray arr = new JSONArray();
            for (int i = 0; i < array.size(); i++) {
                if (i == 0) {
                    String o = array.get(i).toString();
                    arr.add(o+"!@#$");
                }
                arr.add(array.get(i));
            }
            return arr;
        } else if (Objects.equals(ArrCaseRulesEnum.ARR_49.getRuleId(), ruleId)) {
            int arrSize = 101 - array.size();
            for (int i = 0; i < arrSize; i++) {
                array.add("test0" + i);
            }
            return array;
        }
        return paramValue;
    }

    /**
     * 获取json对象中随机一个key组成新对象返回
     * @param arr
     * @param itemRule 数组第一个元素生成规则(只针对字符串)：
     *                 1：单个值含空格-前
     *                 2：单个值含空格-后
     *                 3：单个值含空格-前后
     *                 4：单个值含特殊字符
     * @return
     */
    private JSONArray getTempRuleARR(JSONArray arr,int itemRule) {
        JSONArray tempArr = new JSONArray();
        // 获取数组的第一个元素
        Object firstItem = arr.get(0);
        if (!(firstItem instanceof String)) {
            return arr;
        }
        if (Objects.equals(itemRule,1)) {
            tempArr.add(" "+firstItem);
        }else if (Objects.equals(itemRule,2)) {
            tempArr.add(firstItem + " ");
        }else if (Objects.equals(itemRule,3)) {
            tempArr.add(" "+firstItem+" ");
        }else if (Objects.equals(itemRule,4)) {
            tempArr.add("@#￥%"+firstItem);
        }
        return tempArr;
    }

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        JSONArray array1 = new JSONArray();
        JSONArray array2 = new JSONArray(6);
        json.put("array1",array1);
        json.put("array2",array2);
        System.out.println("json = " + json);

    }
}
