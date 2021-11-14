package com.darling.auto.controller;

import com.alibaba.excel.EasyExcel;
import com.darling.auto.constant.ResponResult;
import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.model.ZdhApiCasesExport;
import com.darling.auto.model.ZdhApiCasesQuery;
import com.darling.auto.service.ZdhApiParamsObtainService;
import com.darling.auto.service.ZdhApiParamsParseService;
import com.darling.auto.utils.BeanCopierUtils;
import com.darling.auto.utils.ExportHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 接口自动化测试用例获取
 * @author: dll
 * @date: Created in 2021/11/4 17:32
 * @version:
 * @modified By:
 */
@RequestMapping("/zdh/apiCases")
@RestController
public class ZdhApiCaseController {

    @Resource
    private ZdhApiParamsObtainService obtainService;

    @Resource
    private ZdhApiParamsParseService paramsParseService;


    @RequestMapping("/parseApiParams")
    public ResponResult parseApiParams(@RequestBody ZdhApiCasesQuery param) {
        paramsParseService.parseJsonParams(param);
        return ResponResult.markSuccess("解析成功!");
    }


    /**
     * 导出指定接口的测试用例
     * @param response
     * @param param
     * @throws Exception
     */
    @RequestMapping("/exportApiCases")
    public void exportList(HttpServletResponse response, ZdhApiCasesQuery param) throws Exception {
        String fileName = param.getApiName() +"测试用例合集";
        ExportHeader.reHeaderByName(response,fileName);
        List<ZdhApiCases> list = obtainService.obtainApiParams(param.getApiUrl());
        List<ZdhApiCasesExport> reportExports = BeanCopierUtils.convertList(list, ZdhApiCasesExport.class);
        EasyExcel.write(response.getOutputStream(), ZdhApiCasesExport.class).sheet(fileName).doWrite(reportExports);
    }

}
