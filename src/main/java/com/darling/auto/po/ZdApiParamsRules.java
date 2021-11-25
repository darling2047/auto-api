package com.darling.auto.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description: 测试用例规则表 zd_api_params_rules
 * @author: dll
 * @date: Created in 2021/11/1 15:36
 * @version:
 * @modified By:
 */
@Data
public class ZdApiParamsRules {

    /**
     * 规则id
     */
    @TableId
    private int ruleId;

    /**
     * 适用的参数类型(1:普通字符串:2:对象;3:数组;4:布尔;5:整形)
     */
    private Integer paramType;

    /**
     * 规则对应的value值
     */
    private String paramValue;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 数组里元素的类型
     */
    private String arrItemType;


}
