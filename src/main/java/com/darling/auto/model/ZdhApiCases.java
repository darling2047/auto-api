package com.darling.auto.model;

import lombok.Data;

/**
 * @description: 接口测试用例封装类
 * @author: dll
 * @date: Created in 2021/11/4 16:33
 * @version:
 * @modified By:
 */
@Data
public class ZdhApiCases {

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口请求路径
     */
    private String apiUrl;

    /**
     * 用例描述
     */
    private String caseDesc;

    /**
     * 请求体
     */
    private String testBody;

    /**
     * 参数id
     */
    private Integer paramId;

}
