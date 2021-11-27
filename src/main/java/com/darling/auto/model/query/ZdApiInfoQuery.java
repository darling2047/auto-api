package com.darling.auto.model.query;

import com.darling.auto.model.base.PageBaseModel;
import lombok.Data;

import java.util.Date;

/**
 * @description: 接口描述信息
 * @author: dll
 * @date: Created in 2021/9/12 17:04
 * @version: 1.0
 * @modified By:
 */
@Data
public class ZdApiInfoQuery extends PageBaseModel {

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
    private Date createTime;

    /**
     * 修改人
     */
    private String updateCreator;

    /**
     * 修改时间
     */
    private Date updateTime;

}
