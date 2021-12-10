package com.darling.auto.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.darling.auto.mapper.ZdApiInfoMapper;
import com.darling.auto.model.ZdApiInfoVo;
import com.darling.auto.model.ZdhApiCasesExcel;
import com.darling.auto.model.ZdhApiCasesQuery;
import com.darling.auto.model.base.PaginationModel;
import com.darling.auto.model.query.ZdApiInfoQuery;
import com.darling.auto.po.ZdApiInfo;
import com.darling.auto.service.ZdApiInfoService;
import com.darling.auto.service.ZdhApiParamsParseService;
import com.darling.auto.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/26 10:41
 * @version:
 * @modified By:
 */
@Service
public class ZdApiInfoServiceImpl implements ZdApiInfoService {

    @Resource
    private ZdApiInfoMapper zdApiInfoMapper;

    @Resource
    private ZdhApiParamsParseService zdhApiParamsParseService;


    @Override
    public PaginationModel<ZdApiInfoVo> getList(ZdApiInfoQuery params) {
        PaginationModel<ZdApiInfoVo> res = new PaginationModel<>();
        QueryWrapper<ZdApiInfo> qw = getQw(params);
        List<ZdApiInfo> zdApiInfos = zdApiInfoMapper.selectList(qw);
        res.setCode(0);
        res.setCount((long) zdApiInfos.size());
        res.setLimit(params.getLimit());
        res.setPage(params.getPage());
        if (zdApiInfos.isEmpty()) {
            return res;
        }
        List<ZdApiInfoVo> list = BeanCopierUtils.convertList(zdApiInfos, ZdApiInfoVo.class);
        res.setData(list);
        return res;
    }

    @Override
    public void insert(ZdApiInfoVo apiInfoVo) {
        ZdApiInfo entity = BeanCopierUtils.convert(apiInfoVo,ZdApiInfo.class);
        entity.setCreator("admin");
        zdApiInfoMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importApi(ZdhApiCasesExcel zdhApiCasesExcel) {
        JSONObject object = JSONObject.parseObject(zdhApiCasesExcel.getTestBody());
        ZdhApiCasesQuery param = BeanCopierUtils.convert(zdhApiCasesExcel,ZdhApiCasesQuery.class);
        ZdApiInfoVo apiInfoVo = BeanCopierUtils.convert(zdhApiCasesExcel,ZdApiInfoVo.class);
        param.setTestBody(object);
        zdhApiParamsParseService.parseJsonParams(param);
        insert(apiInfoVo);
    }

    @Override
    public void delCases(String ids) {
        String[] arr = ids.split(",");
        for (String id : arr) {
            zdApiInfoMapper.deleteById(Integer.parseInt(id));
        }
    }

    private QueryWrapper<ZdApiInfo> getQw(ZdApiInfoQuery params) {
        QueryWrapper<ZdApiInfo> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(params.getApiName())) {
            qw.lambda().like(ZdApiInfo::getApiName,params.getApiName());
        }
        if (StringUtils.isNotBlank(params.getApiUrl())) {
            qw.lambda().like(ZdApiInfo::getApiUrl,params.getApiUrl());
        }
        if (StringUtils.isNotBlank(params.getCreator())) {
            qw.lambda().eq(ZdApiInfo::getCreator,params.getCreator());
        }
        return qw;
    }
}
