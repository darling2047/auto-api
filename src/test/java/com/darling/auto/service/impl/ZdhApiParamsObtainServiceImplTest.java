package com.darling.auto.service.impl;

import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.service.ZdhApiParamsObtainService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/6 21:35
 * @version:
 * @modified By:
 */
@SpringBootTest
class ZdhApiParamsObtainServiceImplTest {

    @Resource
    private ZdhApiParamsObtainService obtainService;


    @Test
    void obtainApiParams() {
        List<ZdhApiCases> apiName03 = obtainService.obtainApiParams("/activity/insert001");
        System.out.println(apiName03.size());

    }
}