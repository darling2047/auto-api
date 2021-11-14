package com.darling.auto.service;

import com.darling.auto.po.ZdApiParams;
import com.darling.auto.po.ZdApiParamsCases;

import java.util.List;

/**
 * @description: 处理接口入参
 * @author: dll
 * @date: Created in 2021/11/1 12:58
 * @version:
 * @modified By:
 */
public interface ZdhApiParamsService {

    /**
     * 保存接口参数
     * @param params
     * @return 新增记录的id
     */
    Integer insertParam(ZdApiParams params);

    /**
     * 根据接口名称获取其对应的测试用例
     * @param apiName
     * @return
     */
    List<ZdApiParamsCases> getCasesByApiName(String apiName);
}
