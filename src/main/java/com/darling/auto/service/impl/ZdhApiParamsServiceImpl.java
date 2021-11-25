package com.darling.auto.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.darling.auto.constant.CommonConstant;
import com.darling.auto.mapper.ZdApiParamsCasesMapper;
import com.darling.auto.mapper.ZdApiParamsRulesMapper;
import com.darling.auto.mapper.ZdhApiParamsMapper;
import com.darling.auto.po.ZdApiParams;
import com.darling.auto.po.ZdApiParamsCases;
import com.darling.auto.po.ZdApiParamsRules;
import com.darling.auto.service.ZdhApiParamsService;
import com.darling.auto.utils.BeanCopierUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/1 12:59
 * @version:
 * @modified By:
 */
@Service
public class ZdhApiParamsServiceImpl implements ZdhApiParamsService {


    @Resource
    private ZdhApiParamsMapper apiParamsMapper;

    @Resource
    private ZdApiParamsRulesMapper rulesMapper;

    @Resource
    private ZdApiParamsCasesMapper casesMapper;

    @Override
    public Integer insertParam(ZdApiParams params) {
        // 添加一条接口入参信息
        apiParamsMapper.insertParam(params);
        // 添加测试用例
        initParamCases(params,null);
        return params.getId();
    }

    @Override
    public List<ZdApiParamsCases> getCasesByApiName(String apiName) {
        return casesMapper.selectList(new QueryWrapper<ZdApiParamsCases>().lambda().eq(ZdApiParamsCases::getApiUrl,apiName));
    }

    @Override
    public Integer inserArrtParam(ZdApiParams params, JSONArray array,boolean isAddCase) {
        // 添加一条接口入参信息
        apiParamsMapper.insertParam(params);
        if (isAddCase) {
            // 添加测试用例
            initParamCases(params,array);
        }
        return params.getId();
    }

    /**
     * 添加一个参数所有可能用到的测试用例
     * @param params
     */
    private void initParamCases(ZdApiParams params, JSONArray array) {
        QueryWrapper<ZdApiParamsRules> qw =  new QueryWrapper<>();
        qw.lambda().eq(ZdApiParamsRules::getParamType, params.getParamType()).isNull(ZdApiParamsRules::getArrItemType)
                .orderByAsc(ZdApiParamsRules::getSort);
        List<ZdApiParamsRules> rules = rulesMapper.selectList(qw);
        List<ZdApiParamsRules> personalRules = new ArrayList<>();
        if (Objects.equals(params.getParamType().intValue(), CommonConstant.PARAMS_TYPE.ARRAY)) {
            String arrItemType = "";
            // 如果是数组,需要根据数组元素的类型来获取对应用例;
            Object o = array.get(0);
            if (o instanceof String) {
                arrItemType = "string";
            }
            if (o instanceof Integer) {
                arrItemType = "integer";
            }
            if (o instanceof Boolean) {
                arrItemType = "boolean";
            }
            if (o instanceof JSONObject) {
                arrItemType = "jsonobject";
            }
            if (!StringUtils.isEmpty(arrItemType)) {
                personalRules = rulesMapper.selectList(new QueryWrapper<ZdApiParamsRules>()
                    .lambda().eq(ZdApiParamsRules::getArrItemType,arrItemType));
            }
        }
        rules.addAll(personalRules);
        for (ZdApiParamsRules rule : rules) {
            ZdApiParamsCases cases = BeanCopierUtils.convert(rule,ZdApiParamsCases.class);
            cases.setParamId(params.getId());
            cases.setApiUrl(params.getApiUrl());
            cases.setApiName(params.getApiName());
            if (Objects.equals(rule.getRuleName(),"正常输入")) {
                cases.setParamValue(params.getParamValue());
            }
            casesMapper.insert(cases);
        }

    }
}
