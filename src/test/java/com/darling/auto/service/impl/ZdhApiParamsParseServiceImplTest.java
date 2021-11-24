package com.darling.auto.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.model.ZdhApiCasesQuery;
import com.darling.auto.service.ZdhApiParamsParseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/5 11:03
 * @version:
 * @modified By:
 */
@SpringBootTest
class ZdhApiParamsParseServiceImplTest {

    @Resource
    private ZdhApiParamsParseService apiParamsService;

    @Test
    void parseJsonParams() {
        String params = "{\n" +
                "\t\"valueId\": \"taskName\",\n" +
                "\t\"stype\": \"title\",\n" +
                "\t\"defaultValue\": \"关于客户关怀着火点预警系统问题反馈\",\n" +
                "\t\"dataType\": \"string\",\n" +
                "\t\"icon\": \"icon-biaoti\",\n" +
                "\t\"label\": \"工单标题\",\n" +
                "\t\"type\": \"input\",\n" +
                "\t\"isRule\": true,\n" +
                "\t\"colspan\": 24,\n" +
                "\t\"width\": \"100%\",\n" +
                "\t\"disabled\": false,\n" +
                "\t\"placeholder\": \"请输入\",\n" +
                "\t\"key\": \"1630567711000_22152\",\n" +
                "\t\"value\": \"关于客户关怀着火点预警系统问题反馈\",\n" +
                "\t\"array\": [{\n" +
                "\t\t\"name\": \"张三丰\"\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"李思思\"\n" +
                "\t}]\n" +
                "}";
        ZdhApiCasesQuery param = new ZdhApiCasesQuery();
        param.setTestBody(JSONObject.parseObject(params));
        param.setApiName("apiName002");
        param.setApiUrl("/test/002");
        apiParamsService.parseJsonParams(param);
    }
}