package com.darling.auto.interceptor;

import com.darling.auto.constant.ResponResult;
import com.darling.auto.constant.ResultCode;
import com.darling.auto.constant.ResultEnum;
import com.darling.auto.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionInterceptor.class);
	
	private final String chnlUrl = "http://localhost:9090/login-1.html";
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponResult doException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		ResponResult rs = new ResponResult(); //默认出错
		logger.error(e.getMessage(), e);
		if(e instanceof BusinessException){
			ResultCode rc=((BusinessException)e).getResultCode();
			if(rc!=null){
				if(ResultEnum.NOLOGIN.getCode().equals(rc.getCode())){
					rs.setObj(chnlUrl);
				}
				rs.setStatus(rc.getCode());
				rs.setMsg(rc.getMsg());
			}
		}else{
			rs.setStatus(ResultEnum.ERROR.getCode());
			rs.setMsg(e.getMessage());
		}
		return rs;
    }  
}
