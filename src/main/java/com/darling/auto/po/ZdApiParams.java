package com.darling.auto.po;

import lombok.Data;

/**
 * @description: 接口入参
 * @author: dll
 * @date: Created in 2021/9/12 17:04
 * @version: 1.0
 * @modified By:
 */
@Data
public class ZdApiParams {

    /**
     * 入参唯一标识
     */
    private Integer id;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口访问路径
     */
    private String apiUrl;

    /**
     * 参数key
     */
    private String paramKey;

    /**
     * 参数值(可为空)
     */
    private String paramValue;

    /**
     * 参数类型(1:普通字符串:2:对象;3:数组;4:布尔;5:整形)
     */
    private Integer paramType;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 数组下标
     */
    private Integer arrIndex;

}
