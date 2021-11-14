package com.darling.auto.exception;


import com.darling.auto.constant.ResultCode;
import com.darling.auto.constant.ResultEnum;

public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private ResultCode resultCode = new ResultCode(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg());
    private Throwable e;
    
    public BusinessException(ResultCode resultCode) {
		this.resultCode=resultCode;
	}
    
    public BusinessException(ResultCode resultCode, Throwable e) {
		this.resultCode=resultCode;
		this.e=e;
	}
    
    public BusinessException(String desc) {
		this.resultCode=new ResultCode(ResultEnum.ERROR.getCode(),desc);
	}
    
    public BusinessException(String desc, Throwable e) {
		this.resultCode=new ResultCode(ResultEnum.ERROR.getCode(),desc);
		this.e=e;
	}
    
    public Throwable getThrowable() {
        return e;
    }
	
	@Override
	public String getMessage() {
		return resultCode.getMsg();
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	

}
