package com.darling.auto.controller;

import com.darling.auto.constant.ResponResult;
import com.darling.auto.constant.SessionConstant;
import com.darling.auto.model.base.UserInfoModel;
import com.darling.auto.po.ZdSysUser;
import com.darling.auto.service.ZdSystemService;
import com.darling.auto.utils.BeanCopierUtils;
import com.darling.auto.utils.TokenUtil;
import com.darling.auto.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        String ipAddr = getIpAddr(request);
        log.info(">>>>>>>>>ipAddr:{},loginName:{},password:{}",ipAddr,loginName,password);
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

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        try {
            System.out.println("x-forwarded-for ip: " + ip);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                // 多次反向代理后会有多个ip值，第一个ip才是真实ip
                if( ip.indexOf(",")!=-1 ){
                    ip = ip.split(",")[0];
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                System.out.println("Proxy-Client-IP ip: " + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                System.out.println("WL-Proxy-Client-IP ip: " + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                System.out.println("HTTP_CLIENT_IP ip: " + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Real-IP");
                System.out.println("X-Real-IP ip: " + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                System.out.println("getRemoteAddr ip: " + ip);
            }
            System.out.println("获取客户端ip: " + ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

}
