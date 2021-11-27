package com.darling.auto.service.impl;

import com.darling.auto.po.ZdSysUser;
import com.darling.auto.service.ZdSystemService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/11/27 21:25
 * @version:
 * @modified By:
 */
@Service
public class ZdSystemServiceImpl implements ZdSystemService {

    @Override
    public ZdSysUser getUserByLoginName(String loginName) {
        ZdSysUser user = new ZdSysUser();
        user.setUserId(88888888);
        user.setUserName("董琳琳");
        user.setLoginName("admin");
        user.setPassword("100200");
        user.setMobile("15867121791");
        return user;
    }
}
