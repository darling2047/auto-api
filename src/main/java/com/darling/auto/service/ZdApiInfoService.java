package com.darling.auto.service;

import com.darling.auto.model.ZdApiInfoVo;
import com.darling.auto.model.ZdhApiCasesExcel;
import com.darling.auto.model.base.PaginationModel;
import com.darling.auto.model.query.ZdApiInfoQuery;

/**
 * @description: 接口描述信息
 * @author: dll
 * @date: Created in 2021/11/26 10:41
 * @version:
 * @modified By:
 */
public interface ZdApiInfoService {

    /**
     * 分页获取接口信息
     * @param params
     * @return
     */
    PaginationModel<ZdApiInfoVo> getList(ZdApiInfoQuery params);

    /**
     * 添加一条接口描述信息
     * @param apiInfoVo
     */
    void insert(ZdApiInfoVo apiInfoVo);

    /**
     * 解析导入的接口信息
     * @param zdhApiCasesExcel
     */
    void importApi(ZdhApiCasesExcel zdhApiCasesExcel);

    /**
     * 删除已生成用例的接口信息
     * @param ids
     */
    void delCases(String ids);
}
