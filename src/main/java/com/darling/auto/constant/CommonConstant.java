package com.darling.auto.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @Author dll
 * @create 2020/5/30 10:07
 * @describe 常量配置类
 */
public class CommonConstant {

    public static final String KPI_MONTH_RULE = "yyyyMM";
    public static final String KPI_DAY_RULE = "yyyyMMdd";

    /**
     * 菜单为子节点(有url)
     */
    public static final Integer MENU_LEAF = 1;

    public static final String MAINTAIN_FILE_PATH = "src/main/resources/files/maintain/";
    public static final String CHECK_FILE_PATH = "src/main/resources/files/check/";

    /**
     * 不需要登录
     */
    public static final Integer NONEED_LOGIN = 0;

    public interface IsDelete {

        /**
         * 未删除
         */
        Integer NOT_DELETE = 0;

        /**
         * 已删除
         */
        Integer ALREADY_DELETE = 1;
    }

    /**
     * 编辑标识
     */
    public interface Flag {
        String ADD = "add";
        String EDIT = "edit";
    }

    /**
     * 部门编号枚举
     */
    public interface DeptNo {

        /**
         * 仓库
         */
        String DEPOSITORY = "DEPT_002";
    }

    /**
     * 是否叶子节点(1,是；0:否)
     */
    public interface IS_LEAF {
        String YES = "1";
        String NO = "0";
    }

    /**
     * 系统支持的角色类型
     */
    public interface ROLE_TYPE {

        /**
         * 主管理员
         */
        String MASTER_ADMINISTRATOR = "ROLE_0001";

        /**
         * 子管理员
         */
        String SUB_ADMINISTRATOR = "ROLE_0002";

        /**
         * 部门设备管理员
         */
        String DEPT_DEVICE_ADMINISTRATOR = "ROLE_0003";

        /**
         * 部门领导
         */
        String DEPT_LEADER = "ROLE_0004";

        /**
         * 普通保管员
         */
        String CUSTODIAN = "ROLE_0005";

    }

    /**
     * 设备日常维护的操作类型 1:校准;2:核查;3:保养
     */
    public interface OPER_TYPE {

        /**
         * 校准
         */
        int EASYALIGN = 1;

        /**
         * 核查
         */
        int CHECKDEVICE = 2;

        /**
         * 保养
         */
        int MAINTAIN = 3;
    }

    /**
     * 资产(设备)类型
     */
    public interface ASSETS_TYPE {

        /**
         * 办公设备
         */
        Integer WORKDEVICE = 1;

        /**
         * 检测设备
         */
        Integer TESTINGDEVICE = 2;

        /**
         * 信息设备
         */
        Integer INFODEVICE = 3;

        /**
         * 生产设备
         */
        Integer PRDDEVICE = 4;

        /**
         * 工具
         */
        Integer TOOLDEVICE = 5;
    }

    public static List<String> UPDATELIST = Arrays.asList("save","delDevice","delUserInfoById"
            ,"update","edit","changeDeviceStatus","maintainDevice","createPlan","importMaintainFile");

    public static List<String> DEPTURLLIST = Arrays.asList("editUserInfo","delUserInfoById");

    /**
     * 参数类型
     */
    public interface PARAMS_TYPE {
        /**
         * 普通字符串
         */
        int STR = 1;

        /**
         * json对象
         */
        int OBJECT = 2;

        /**
         * json数组
         */
        int ARRAY = 3;

        /**
         * 布尔类型
         */
        int BOOLEAN = 4;

        /**
         * 整形
         */
        int INTEGER = 5;
    }
}
