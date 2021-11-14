package com.darling.auto.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description: 接口测试用例导出
 * @author: dll
 * @date: Created in 2021/11/4 16:33
 * @version:
 * @modified By:
 */
@Data
public class ZdhApiCasesExport {

    /**
     * 接口名称
     */
    @ExcelProperty({"接口名称"})
    private String apiName;

    /**
     * 接口请求路径
     */
    @ExcelProperty({"接口请求路径"})
    private String apiUrl;

    /**
     * 用例描述
     */
    @ExcelProperty({"用例描述"})
    private String caseDesc;

    /**
     * 请求体
     */
    @ExcelProperty({"请求体"})
    private String testBody;

    /**
     * 参数id
     */
    @ExcelProperty({"参数id"})
    private Integer paramId;

}
