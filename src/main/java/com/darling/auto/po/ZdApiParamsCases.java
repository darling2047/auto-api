package com.darling.auto.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description: 接口参数测试用例 zd_api_params_cases
 * @author: dll
 * @date: Created in 2021/11/1 15:36
 * @version:
 * @modified By:
 */
@Data
public class ZdApiParamsCases {

    /**
     * 用例id
     */
    @TableId(type = IdType.INPUT)
    private Integer caseId;

    /**
     * zd_api_params的id
     */
    private Integer paramId;

    /**
     * 测试用例的规则id
     */
    private int ruleId;

    /**
     * 规则id对应规则生成的value值
     */
    private String paramValue;

    /**
     * 是否已经生成测试用例(1:是；0:否)
     */
    private Integer status;

    /**
     * 接口访问路径
     */
    private String apiUrl;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 适用的参数类型(1:普通字符串:2:对象;3:数组;4:布尔;5:整形)
     */
    private Integer paramType;

}
