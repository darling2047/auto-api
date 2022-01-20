package com.darling.auto.controller;

import com.darling.auto.model.*;
import com.darling.auto.model.base.PaginationModel;
import com.darling.auto.model.query.ZdApiRuleQuery;
import com.darling.auto.service.ZdhApiRuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 接口用例生成规则配置
 * @author: dll
 * @date: Created in 2021/11/4 17:32
 * @version:
 * @modified By:
 */
@RequestMapping("/apiRule")
@RestController
public class ZdhApiRuleController {

    @Resource
    private ZdhApiRuleService zdhApiRuleService;

    /**
     * 分页获取规则信息
     * @param params
     * @return
     */
    @RequestMapping("/getList")
    public PaginationModel<ZdApiParamsRulesVo> getList(ZdApiRuleQuery params) {
        PaginationModel<ZdApiParamsRulesVo> page = zdhApiRuleService.getList(params);
        return page;
    }

}
