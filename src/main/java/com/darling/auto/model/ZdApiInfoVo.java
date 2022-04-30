package com.darling.auto.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 接口描述信息
 * @author: dll
 * @date: Created in 2021/9/12 17:04
 * @version: 1.0
 * @modified By:
 */
@Data
public class ZdApiInfoVo implements Serializable {

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
     * 入参
     */
    private String testBody;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改人
     */
    private String updateCreator;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
