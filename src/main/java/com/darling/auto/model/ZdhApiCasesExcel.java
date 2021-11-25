package com.darling.auto.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @description: 接口测试用例 excel封装类
 * @author: dll
 * @date: Created in 2021/11/4 16:33
 * @version:
 * @modified By:
 */
@Data
public class ZdhApiCasesExcel {

    @ExcelProperty({"接口名称"})
    private String apiName;

    @ExcelProperty({"接口请求路径"})
    private String apiUrl;

    @ExcelProperty({"请求体"})
    private String testBody;

}
