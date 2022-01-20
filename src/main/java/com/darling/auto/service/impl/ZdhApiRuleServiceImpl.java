package com.darling.auto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.darling.auto.constant.CommonConstant;
import com.darling.auto.constant.ParamTypeEnum;
import com.darling.auto.mapper.ZdApiParamsRulesMapper;
import com.darling.auto.model.ZdApiParamsRulesVo;
import com.darling.auto.model.base.PaginationModel;
import com.darling.auto.model.query.ZdApiRuleQuery;
import com.darling.auto.po.ZdApiParamsRules;
import com.darling.auto.service.ZdhApiRuleService;
import com.darling.auto.utils.BeanCopierUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: dll
 * @date: Created in 2022/1/20 17:20
 * @version:
 * @modified By:
 */
@Service
public class ZdhApiRuleServiceImpl implements ZdhApiRuleService {

    @Resource
    private ZdApiParamsRulesMapper zdApiParamsRulesMapper;

    @Override
    public PaginationModel<ZdApiParamsRulesVo> getList(ZdApiRuleQuery params) {
        PaginationModel<ZdApiParamsRulesVo> res = new PaginationModel<>();
        QueryWrapper<ZdApiParamsRules> qw = getQw(params);
        List<ZdApiParamsRules> zdApiInfos = zdApiParamsRulesMapper.selectList(qw);
        res.setCode(0);
        res.setCount((long) zdApiInfos.size());
        res.setLimit(params.getLimit());
        res.setPage(params.getPage());
        if (zdApiInfos.isEmpty()) {
            return res;
        }
        List<ZdApiParamsRulesVo> list = BeanCopierUtils.convertList(zdApiInfos, ZdApiParamsRulesVo.class);
        list.forEach(item -> {
            item.setParamTypeName(ParamTypeEnum.getDescByParamType(item.getParamType()));
        });
        res.setData(list);
        return res;
    }

    private QueryWrapper<ZdApiParamsRules> getQw(ZdApiRuleQuery params) {
        QueryWrapper<ZdApiParamsRules> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(params.getRuleName())) {
            qw.lambda().like(ZdApiParamsRules::getRuleName,params.getRuleName());
        }
        if (Objects.nonNull(params.getParamType())) {
            qw.lambda().eq(ZdApiParamsRules::getParamType,params.getParamType());
        }
        qw.lambda().orderByDesc(ZdApiParamsRules::getCreateTime);
        return qw;
    }
}
