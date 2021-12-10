package com.darling.auto.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.darling.auto.annotation.ApiValueProductCase;
import com.darling.auto.constant.CommonConstant;
import com.darling.auto.mapper.ZdApiParamsRulesMapper;
import com.darling.auto.mapper.ZdhApiParamsMapper;
import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.po.ZdApiParams;
import com.darling.auto.po.ZdApiParamsCases;
import com.darling.auto.po.ZdApiParamsRules;
import com.darling.auto.service.ZdhApiParamsObtainService;
import com.darling.auto.service.ZdhApiParamsService;
import com.darling.auto.service.ZdhApiValueProductService;
import com.darling.auto.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/10/28 17:05
 * @version:
 * @modified By:
 */
@Service
public class ZdhApiParamsObtainServiceImpl implements ZdhApiParamsObtainService {

    @Resource
    private ZdhApiParamsMapper apiParamsMapper;

    @Resource
    private ZdhApiParamsService apiParamsService;

    @Resource
    private ZdApiParamsRulesMapper apiParamsRulesMapper;

    @Resource
    private List<ZdhApiValueProductService> apiValueProductServiceList;

    @Override
    public List<ZdhApiCases> obtainApiParams(String apiUrl) {
        List<ZdhApiCases> list = new ArrayList<>();
        List<ZdApiParams> rootParams = apiParamsMapper.selectList(
                new QueryWrapper<ZdApiParams>().lambda().eq(ZdApiParams::getApiUrl, apiUrl)
                        .isNull(ZdApiParams::getParentId));
        if (rootParams.isEmpty()) {
            return list;
        }
        // 获取接口对应的测试用例
        List<ZdApiParamsCases> casesList = apiParamsService.getCasesByApiName(apiUrl);
        for (ZdApiParamsCases cases : casesList) {
            ZdhApiCases item = BeanCopierUtils.convert(cases,ZdhApiCases.class);
            // 解析入库字段,拼接成json对象
            JSONObject res = parseApiParams(rootParams,cases);
            item.setTestBody(res.toJSONString());
            item.setCaseDesc(getCaseDesc(cases));
            list.add(item);
        }
        Map<Integer, List<ZdhApiCases>> collect = list.stream().collect(Collectors.groupingBy(ZdhApiCases::getParamId));
        return list;
    }

    /**
     * 获取测试用例描述信息
     * @param cases
     * @return
     */
    private String getCaseDesc(ZdApiParamsCases cases) {
        ZdApiParams param = apiParamsMapper.selectById(cases.getParamId());
        ZdApiParamsRules zdApiParamsRules = apiParamsRulesMapper.selectById(cases.getRuleId());
        String format = String.format(zdApiParamsRules.getRuleName(), param.getParamKey());
        return format;
    }

    /**
     * 解析参数列表
     *
     * @param rootParams
     */
    private JSONObject parseApiParams(List<ZdApiParams> rootParams,ZdApiParamsCases cases ) {
        JSONObject res = new JSONObject();
        for (ZdApiParams rootParam : rootParams) {
            // 获取当前节点的类型
            Integer rootParamType = rootParam.getParamType();
            if (Objects.equals(CommonConstant.PARAMS_TYPE.STR, rootParamType)) {
                // 参数是字符串类型
                res.put(rootParam.getParamKey(), getParamValue(rootParam,cases));
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.BOOLEAN, rootParamType)) {
                // 参数是布尔类型
                res.put(rootParam.getParamKey(), getParamValue(rootParam,cases));
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.INTEGER, rootParamType)) {
                // 参数是整型
                res.put(rootParam.getParamKey(), getParamValue(rootParam,cases));
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.OBJECT, rootParamType)) {
                // 参数是JSON对象
                JSONObject json = getJSONObject(rootParam,cases);
                res.put(rootParam.getParamKey(), json);
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.ARRAY, rootParamType)) {
                // 参数是JSON数组
                JSONArray jsonArr = getJSONArray(rootParam,cases);
                res.put(rootParam.getParamKey(), jsonArr);
            }
        }
        return res;

    }


    /**
     * 获取value
     * @param rootParam
     * @return
     */
    private Object getParamValue(ZdApiParams rootParam,ZdApiParamsCases cases) {
        Object paramValue = rootParam.getParamValue();
        ZdhApiValueProductService valueProductService = getApiValueCaseService(cases.getParamType());
        // 如果当前循环到的param表中的id等于当前用例的paramId，表示需要特殊处理生成case里ruleId对应规则value
        if (Objects.equals(rootParam.getId(),cases.getParamId())) {
            paramValue = valueProductService.getValueByRuleId(cases.getRuleId(),rootParam.getParamValue());
        }
        // 如果二者不等,直接返回param里的value
        return paramValue;
    }

    private ZdhApiValueProductService getApiValueCaseService(Integer paramType) {
        return apiValueProductServiceList.stream().filter(service -> {
            ApiValueProductCase valueProductCase = service.getClass().getAnnotation(ApiValueProductCase.class);
            if (Objects.isNull(valueProductCase)) {
                return false;
            }
            if (Objects.equals(valueProductCase.value(), paramType.intValue())) {
                return true;
            }
            return false;
        }).findFirst().orElse(null);
    }

    /**
     * 获取json对象
     *
     * @param rootParam
     * @return
     */
    private JSONObject getJSONObject(ZdApiParams rootParam,ZdApiParamsCases cases) {
        JSONObject childJson = new JSONObject();
        // 获取下级节点
        List<ZdApiParams> childParams = getChildParams(rootParam.getId());
        for (ZdApiParams childParam : childParams) {
            // 获取当前节点的类型
            Integer childParamType = childParam.getParamType();
            if (Objects.equals(CommonConstant.PARAMS_TYPE.STR, childParamType)) {
                // 参数是字符串类型
                childJson.put(childParam.getParamKey(), getParamValue(childParam,cases));
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.BOOLEAN, childParamType)) {
                // 参数是布尔类型
                childJson.put(childParam.getParamKey(), getParamValue(childParam,cases));
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.INTEGER, childParamType)) {
                // 参数是整型
                childJson.put(childParam.getParamKey(), getParamValue(childParam,cases));
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.OBJECT, childParamType)) {
                // 参数是JSON对象
                JSONObject json = getJSONObject(childParam,cases);
                childJson.put(childParam.getParamKey(), json);
            }
            if (Objects.equals(CommonConstant.PARAMS_TYPE.ARRAY, childParamType)) {
                // 参数是JSON数组
                JSONArray jsonArr = getJSONArray(childParam,cases);
                childJson.put(childParam.getParamKey(), jsonArr);
            }
        }
        // 根据规则生成测试用例对应的value
        if (Objects.equals(rootParam.getId(), cases.getParamId())) {
            ZdhApiValueProductService valueProductService = getApiValueCaseService(cases.getParamType());
            Object tempObj = valueProductService.getValueByRuleId(cases.getRuleId(), childJson);
            if (Objects.isNull(tempObj)) {
                childJson = null;
            }else {
                childJson = JSONObject.parseObject(tempObj.toString());
            }
        }
        return childJson;
    }

    /**
     * 獲取json數組
     * @param parentParam
     * @return
     */
    private JSONArray getJSONArray(ZdApiParams parentParam,ZdApiParamsCases cases) {
        JSONArray resArr = new JSONArray();
        // 获取下级节点
        List<ZdApiParams> childParams = getChildParams(parentParam.getId());
        // 将数组里的元素按索引下标分组遍历
        Map<Integer, List<ZdApiParams>> map = childParams.stream().collect(Collectors.groupingBy(ZdApiParams::getArrIndex));
        Set<Integer> indexKey = map.keySet();
        for (Integer indexItem : indexKey) {
            JSONObject objItem = new JSONObject();
            List<ZdApiParams> zdApiParams = map.get(indexItem);
            // resArr是否已添加元素
            boolean resArrIsAdd = false;
            for (ZdApiParams childParam : zdApiParams) {
                if (StringUtils.isBlank(childParam.getParamKey())) {
                    resArr.add(childParam.getParamValue());
                    resArrIsAdd = true;
                    continue;
                }
                // 获取当前节点的类型
                Integer childParamType = childParam.getParamType();
                if (Objects.equals(CommonConstant.PARAMS_TYPE.STR, childParamType)) {
                    // 参数是字符串类型
                    objItem.put(childParam.getParamKey(), getParamValue(childParam,cases));
                }
                if (Objects.equals(CommonConstant.PARAMS_TYPE.BOOLEAN, childParamType)) {
                    // 参数是布尔类型
                    objItem.put(childParam.getParamKey(), getParamValue(childParam,cases));
                }
                if (Objects.equals(CommonConstant.PARAMS_TYPE.INTEGER, childParamType)) {
                    // 参数是整型
                    objItem.put(childParam.getParamKey(), getParamValue(childParam,cases));
                }
                if (Objects.equals(CommonConstant.PARAMS_TYPE.OBJECT, childParamType)) {
                    // 参数是JSON对象
                    JSONObject json = getJSONObject(childParam,cases);
                    objItem.put(childParam.getParamKey(), json);
                }
                if (Objects.equals(CommonConstant.PARAMS_TYPE.ARRAY, childParamType)) {
                    // 参数是JSON数组
                    JSONArray jsonArr = getJSONArray(childParam,cases);
                    objItem.put(childParam.getParamKey(), jsonArr);
                }

            }
            if (!resArrIsAdd) {
                resArr.add(objItem);
            }
        }
        // 根据规则生成测试用例对应的value
        if (Objects.equals(parentParam.getId(), cases.getParamId())) {
            ZdhApiValueProductService valueProductService = getApiValueCaseService(cases.getParamType());
            Object tempObj = valueProductService.getValueByRuleId(cases.getRuleId(), resArr);
            if (Objects.isNull(tempObj)) {
                resArr = null;
            }else {
                resArr = JSONArray.parseArray(tempObj.toString());
            }
        }
        return resArr;

    }

    /**
     * 根据父id获取下级节点元素
     *
     * @param id
     * @return
     */
    private List<ZdApiParams> getChildParams(Integer id) {
        return apiParamsMapper.selectList(
                new QueryWrapper<ZdApiParams>().lambda().eq(ZdApiParams::getParentId, id));
    }
}
