package com.darling.auto.service;

import com.alibaba.fastjson.JSONArray;
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
     * 保存除数组外的接口参数
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


    /**
     * 保存数组的接口参数
     * @param params
     * @param array
     * @param isAddCase  是否需要添加测试用例  数组里的元素不需要添加测试用
     * @return 新增记录的id
     */
    Integer inserArrtParam(ZdApiParams params, JSONArray array,boolean isAddCase);
}
