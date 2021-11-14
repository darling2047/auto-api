package com.darling.auto.service;

import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.model.ZdhApiCasesQuery;

/**
 * @description: 自动化接口入参解析入库
 * @author: dll
 * @date: Created in 2021/9/12 17:01
 * @version: 1.0
 * @modified By:
 */
public interface ZdhApiParamsParseService {

    /**
     * 解析接口的入参并入库
     * @param param
     */
    void parseJsonParams(ZdhApiCasesQuery param);

}
