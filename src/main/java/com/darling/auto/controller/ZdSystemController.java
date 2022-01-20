package com.darling.auto.controller;

import com.darling.auto.constant.ResponResult;
import com.darling.auto.constant.SessionConstant;
import com.darling.auto.model.base.UserInfoModel;
import com.darling.auto.po.ZdSysUser;
import com.darling.auto.service.ZdSystemService;
import com.darling.auto.utils.BeanCopierUtils;
import com.darling.auto.utils.TokenUtil;
import com.darling.auto.utils.UserUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @description: 系统相关操作 CONTROLLER
 * @author: dll
 * @date: Created in 2021/11/27 21:22
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("system")
public class ZdSystemController {


    @Resource
    private ZdSystemService systemService;

    @RequestMapping("/main")
    public void main (HttpServletResponse response) throws IOException {

        response.sendRedirect("/page/login-1.html");

    }

    @RequestMapping("/login")
    public ResponResult doLogin(String loginName, String password,
                                HttpServletRequest request) {
        UserUtils.setRequest(request);
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password)) {
            return ResponResult.markError("用户名密码不能为空!");
        }
        ZdSysUser userInfo = systemService.getUserByLoginName(loginName);
        if (Objects.isNull(userInfo)) {
            return ResponResult.markError("用户名不存在,请确认后重试!");
        }
        if (!Objects.equals(userInfo.getPassword(), password)) {
            return ResponResult.markError("密码错误,请确认后重试!");
        }
        UserInfoModel convert = BeanCopierUtils.convert(userInfo, UserInfoModel.class);
        try {
            TokenUtil.setUser(convert);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponResult.markError("用户信息设置异常:"+e.getMessage());
        }
        return ResponResult.markSuccess(convert);
    }

}
