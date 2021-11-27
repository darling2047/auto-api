package com.darling.auto.service;

import com.darling.auto.model.base.UserInfoModel;
import com.darling.auto.po.ZdSysUser;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/27 21:25
 * @version:
 * @modified By:
 */
public interface ZdSystemService {

    /**
     * 根据登录账号获取用户信息
     * @param loginName
     * @return
     */
    ZdSysUser getUserByLoginName(String loginName);
}
