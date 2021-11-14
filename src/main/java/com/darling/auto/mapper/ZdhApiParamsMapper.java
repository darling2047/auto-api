package com.darling.auto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.darling.auto.po.ZdApiParams;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: dll
 * @date: Created in 2021/9/12 17:03
 * @version: 1.0
 * @modified By:
 */
public interface ZdhApiParamsMapper extends BaseMapper<ZdApiParams> {

    /**
     * 插入数据,返回主键id
     * @param params
     * @return
     */
    Integer insertParam(@Param(value = "params") ZdApiParams params);
}
