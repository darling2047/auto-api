package com.darling.auto.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 *
 */
@Data
public class PageBaseModel  {

	/**
     * 第几页
     */
    private Integer page = 1;

    /**
     * 每页显示几行
     */
    private Integer limit = 15;

}
