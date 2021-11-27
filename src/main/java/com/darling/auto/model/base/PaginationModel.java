package com.darling.auto.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @Author dll
 * @create 2020/3/24 15:54
 * @describe 通用分页返回对象
 */
@Data
public class PaginationModel<T> implements Serializable {

	private static final long serialVersionUID = -1207759792579934735L;

	/**第几页*/
	private Integer page;
	
	/**每页记录数*/
	private Integer limit;
	
	/**总记录数*/
	private Long count;
	
	/**数据集合*/
	private List<T> data;

	private Integer code;

	public PaginationModel() {
		super();
	}

	public PaginationModel(Integer pageIndex, Integer pageSize, Long total, List<T> list, Integer code) {
		super();
		this.page = pageIndex;
		this.limit = pageSize;
		this.count = total;
		this.data = list;
		this.code = code;
	}

}
