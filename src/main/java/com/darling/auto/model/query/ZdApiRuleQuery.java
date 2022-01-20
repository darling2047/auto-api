package com.darling.auto.model.query;

import com.darling.auto.model.base.PageBaseModel;
import lombok.Data;

import java.util.Date;

/**
 * @description: 接口描述信息
 * @author: dll
 * @date: Created in 2021/9/12 17:04
 * @version: 1.0
 * @modified By:
 */
@Data
public class ZdApiRuleQuery extends PageBaseModel {

    /**
     * 规则id
     */
    private Integer id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 参数类型
     */
    private Integer paramType;


}
