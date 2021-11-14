package com.darling.auto.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.darling.auto.constant.CommonConstant;
import com.darling.auto.exception.BusinessException;
import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.model.ZdhApiCasesQuery;
import com.darling.auto.po.ZdApiParams;
import com.darling.auto.service.ZdhApiParamsParseService;
import com.darling.auto.service.ZdhApiParamsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/12 17:02
 * @version: 1.0
 * @modified By:
 */
@Service
public class ZdhApiParamsParseServiceImpl implements ZdhApiParamsParseService {

    @Resource
    private ZdhApiParamsService zdhApiParamsService;

    public void parseJsonParams(ZdhApiCasesQuery param) {
        String jsonStr = param.getTestBody().toJSONString();
        JSONObject jsonObject;
        try {
            jsonObject = JSONObject.parseObject(jsonStr);
        }catch (Exception e) {
            throw new BusinessException("入参格式错误!");
        }
        // 获取入参的所有key
        Set<String> paramKeys = jsonObject.keySet();
        parseKey(paramKeys,jsonObject,null,param.getApiName(),null,param.getApiUrl());

    }

    /**
     * 解析json的key并入库
     * @param paramKeys
     * @param jsonObject
     * @param pid
     */
    private void parseKey(Set<String> paramKeys,JSONObject jsonObject,Integer pid,String apiName
            ,Integer arrIndex,String apiUrl) {
        for (String key : paramKeys) {
            ZdApiParams params = new ZdApiParams();
            params.setApiName(apiName);
            params.setApiUrl(apiUrl);
            params.setParamKey(key);
            params.setParentId(pid);
            params.setArrIndex(arrIndex);
            // key对应的value是否为json对象
            boolean objFlag = false;
            // key对应的value是否为json数组
            boolean arrFlag = false;
            Object value = jsonObject.get(key);
            if (Objects.equals(key,"booleanParam")) {
                System.out.println();
            }
            if (Objects.equals(key,"integerParam")) {
                System.out.println();
            }
            if (value instanceof JSONObject) {
                objFlag = true;
            }
            if (value instanceof JSONArray) {
                arrFlag = true;
            }
            if (objFlag) {
                // 如果value是json对象,则递归调用解析入库
                parseObj(apiName, params, (JSONObject) value,apiUrl);
            }else if (arrFlag) {
                // 如果value是json数组,则遍历数组,再递归调用解析入库
                parseArr(apiName, params, (JSONArray) value,true,apiUrl);
            }else if (value instanceof Boolean) {
                params.setParamType(CommonConstant.PARAMS_TYPE.BOOLEAN);
                if (Objects.nonNull(value)) {
                    params.setParamValue(value.toString());
                }else {
                    System.out.println();
                }
                zdhApiParamsService.insertParam(params);
            }else if (value instanceof Integer) {
                params.setParamType(CommonConstant.PARAMS_TYPE.INTEGER);
                if (Objects.nonNull(value)) {
                    params.setParamValue(value.toString());
                }else {
                    System.out.println();
                }
                zdhApiParamsService.insertParam(params);
            }else {
                // 否则当作普通字符串处理
                params.setParamType(CommonConstant.PARAMS_TYPE.STR);
                if (Objects.nonNull(value)) {
                    params.setParamValue(value.toString());
                }else {
                    System.out.println();
                }
                zdhApiParamsService.insertParam(params);
            }
            System.out.println(value);
        }
    }

    /**
     * 解析json数组
     * @param apiName
     * @param params
     * @param value
     * @param isInnerArr  是否数组里的嵌套数组,如果是则不入库
     */
    private void parseArr(String apiName, ZdApiParams params, JSONArray value,boolean isInnerArr,String apiUrl) {
        JSONArray jsonArr = value;
        if (isInnerArr) {
            params.setParamType(CommonConstant.PARAMS_TYPE.ARRAY);
            zdhApiParamsService.insertParam(params);
        }
        for (int i = 0; i < jsonArr.size(); i++) {
            Object o = jsonArr.get(i);
            if (o instanceof JSONObject) {
                JSONObject jso = (JSONObject) o;
                Set<String> keySet = jso.keySet();
                parseKey(keySet,jso,params.getId(),apiName,i,apiUrl);
            }else if (o instanceof JSONArray) {
                JSONArray tempArr = (JSONArray) o;
                parseArr(apiName,params,tempArr,false,apiUrl);
            }else {
                System.out.println("意料之外的类型");
            }
        }
    }

    /**
     * 解析json对象
     * @param apiName
     * @param params
     * @param value
     */
    private void parseObj(String apiName, ZdApiParams params, JSONObject value,String apiUrl) {
        params.setParamType(CommonConstant.PARAMS_TYPE.OBJECT);
        zdhApiParamsService.insertParam(params);
        JSONObject json = value;
        Set<String> keySet = json.keySet();
        parseKey(keySet,json,params.getId(),apiName,null,apiUrl);
    }

}
