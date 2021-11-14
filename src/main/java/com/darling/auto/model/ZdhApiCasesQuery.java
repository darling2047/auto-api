package com.darling.auto.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @description: 接口测试用例封装类
 * @author: dll
 * @date: Created in 2021/11/4 16:33
 * @version:
 * @modified By:
 */
@Data
public class ZdhApiCasesQuery {

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
    private JSONObject testBody;

    /**
     * 参数id
     */
    private Integer paramId;

}
