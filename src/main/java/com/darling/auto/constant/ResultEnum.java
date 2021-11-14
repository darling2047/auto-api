package com.darling.auto.constant;


public class ResultEnum {

	public final static ResultCode SUCCESS = new ResultCode(0, "成功");
	public final static ResultCode ERROR = new ResultCode(1, "出错");
	public final static ResultCode NOLOGIN = new ResultCode(2, "未登录");
	public final static ResultCode REFRESH = new ResultCode(3, "刷新");
	public final static ResultCode DUPLICATE_SUBMIT = new ResultCode(4, "重复提交");

}
