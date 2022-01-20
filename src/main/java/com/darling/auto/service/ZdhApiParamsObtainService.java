package com.darling.auto.service;

import com.darling.auto.model.ZdhApiCases;

import java.util.List;

/**
 * @description: 获取已经入库的自动化接口入参
 * @author: dll
 * @date: Created in 2021/10/28 17:04
 * @version:
 * @modified By:
 */
public interface ZdhApiParamsObtainService {

    /**
     * 从数据库获取指定接口的入参
     * @param apiUrl
     * @return
     */
    List<ZdhApiCases> obtainApiParams(String apiUrl);

}
