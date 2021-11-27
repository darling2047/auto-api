package com.darling.auto.listeners;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.darling.auto.model.ZdApiInfoVo;
import com.darling.auto.model.ZdhApiCasesExcel;
import com.darling.auto.model.ZdhApiCasesQuery;
import com.darling.auto.service.ZdApiInfoService;
import com.darling.auto.service.ZdhApiParamsParseService;
import com.darling.auto.utils.BeanCopierUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 解析excel获取接口信息
 * @author: dll
 * @date: Created in 2021/11/25 15:00
 * @version:
 * @modified By:
 */
public class ZdApiImportListener extends AnalysisEventListener<ZdhApiCasesExcel> {

    private ZdApiInfoService zdApiInfoService;

    private List<ZdhApiCasesExcel> dataList;

    public ZdApiImportListener(ZdApiInfoService zdApiInfoService) {
        dataList = new ArrayList<>();
        this.zdApiInfoService = zdApiInfoService;
    }

    @Override
    public void invoke(ZdhApiCasesExcel zdhApiCasesExcel, AnalysisContext analysisContext) {
        dataList.add(zdhApiCasesExcel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        for (ZdhApiCasesExcel zdhApiCasesExcel : dataList) {
            zdApiInfoService.importApi(zdhApiCasesExcel);
        }
    }
}
