package com.darling.auto.service;

/**
 * @description: 生产接口参数值的测试用例
 * @author: dll
 * @date: Created in 2021/11/14 19:59
 * @version:
 * @modified By:
 */
public interface ZdhApiValueProductService {

    /**
     * 根据规则id获取接口参数对应的测试用例的值
     * @param ruleId
     * @param paramValue
     * @return
     */
    Object getValueByRuleId(Integer ruleId,String paramValue);

}
