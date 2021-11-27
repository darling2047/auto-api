package com.darling.auto.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.darling.auto.constant.ResponResult;
import com.darling.auto.exception.BusinessException;
import com.darling.auto.listeners.ZdApiImportListener;
import com.darling.auto.model.ZdhApiCases;
import com.darling.auto.model.ZdhApiCasesExcel;
import com.darling.auto.model.ZdhApiCasesExport;
import com.darling.auto.model.ZdhApiCasesQuery;
import com.darling.auto.service.ZdApiInfoService;
import com.darling.auto.service.ZdhApiParamsObtainService;
import com.darling.auto.service.ZdhApiParamsParseService;
import com.darling.auto.utils.BeanCopierUtils;
import com.darling.auto.utils.ExportHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Resource
    private ZdApiInfoService zdApiInfoService;


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

    /**
     * 接口文件上传
     * @return
     */
    @RequestMapping("/import")
    public ResponResult uploadFile(@RequestParam("upExcel") MultipartFile file) throws IOException {
        ZdApiImportListener listener = new ZdApiImportListener(zdApiInfoService);
        EasyExcel.read(file.getInputStream(), ZdhApiCasesExcel.class, listener).sheet().doRead();
        return ResponResult.markSuccess("SUCCESS");
    }

    /**
     * 获取接口上传文件模板
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getTemplate")
    public void getTemplate(HttpServletResponse response) throws IOException {
        List<ZdhApiCasesExcel> list = new ArrayList<>();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=apiTestCase.xlsx");
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        ZdhApiCasesExcel excel = new ZdhApiCasesExcel();
        list.add(excel);
        excelWriter.write(list, EasyExcel.writerSheet(1,"接口列表")
                .head(ZdhApiCasesExcel.class).build());
        excelWriter.finish();
    }

}
