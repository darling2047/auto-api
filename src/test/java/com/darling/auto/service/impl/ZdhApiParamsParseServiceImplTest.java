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
                "\t\"dataType\": {\n" +
                "\t\t\"isZip\": \"N\",\n" +
                "\t\t\"format\": \"JSON\"\n" +
                "\t},\n" +
                "\t\"startID\": 1,\n" +
                "\t\"isSuccess\": true,\n" +
                "\t\"data\": {\n" +
                "\t\t\"measurePointID\": \"0000000000000000100015011000\",\n" +
                "\t\t\"filters\": {\n" +
                "\t\t\t\"startTime\": \"2019-09-10 00:00:00\",\n" +
                "\t\t\t\"endTime\": \"2019-09-20 00:00:00\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        ZdhApiCasesQuery param = new ZdhApiCasesQuery();
        param.setTestBody(JSONObject.parseObject(params));
        param.setApiName("apiName001");
        param.setApiUrl("/test/apiName001");
        apiParamsService.parseJsonParams(param);
    }
}