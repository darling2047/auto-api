package com.darling.auto.controller;

import com.darling.auto.model.ZdApiInfoVo;
import com.darling.auto.model.base.PaginationModel;
import com.darling.auto.model.query.ZdApiInfoQuery;
import com.darling.auto.service.ZdApiInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/26 10:54
 * @version:
 * @modified By:
 */
@RequestMapping("/apiInfo")
@RestController
public class ZdhApiInfoController {

    @Resource
    private ZdApiInfoService zdApiInfoService;

    /**
     * 分页获取接口信息
     * @param params
     * @return
     */
    @RequestMapping("/getList")
    public PaginationModel<ZdApiInfoVo> getList(ZdApiInfoQuery params) {
        PaginationModel<ZdApiInfoVo> page = zdApiInfoService.getList(params);
        return page;
    }

}
