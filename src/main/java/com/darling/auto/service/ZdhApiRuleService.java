package com.darling.auto.service;

import com.darling.auto.model.ZdApiParamsRulesVo;
import com.darling.auto.model.base.PaginationModel;
import com.darling.auto.model.query.ZdApiRuleQuery;

/**
 * @description:
 * @author: dll
 * @date: Created in 2022/1/20 17:20
 * @version:
 * @modified By:
 */
public interface ZdhApiRuleService {

    /**
     * 分页获取规则信息
     * @param params
     * @return
     */
    PaginationModel<ZdApiParamsRulesVo> getList(ZdApiRuleQuery params);
}
