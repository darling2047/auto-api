/**
 * 
 */
package com.darling.auto.utils;

import com.darling.auto.constant.SessionConstant;
import com.darling.auto.model.base.UserInfoModel;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Objects;

/**
 * @author t-xiabin
 *
 */
@Slf4j
public class TokenUtil {

	public static UserInfoModel getUser() {
		HttpServletRequest request = UserUtils.getRequest();
		return (UserInfoModel)request.getSession().getAttribute(SessionConstant.SYS_USER);
	}


	public static UserInfoModel getUser(HttpServletRequest request){
		if (Objects.isNull(request)) {
			return null;
		}
		HttpSession session = request.getSession();
		return (UserInfoModel)request.getSession().getAttribute(SessionConstant.SYS_USER);
	}
	
	public static void setUser(UserInfoModel user){
		UserUtils.getRequest().getSession().setAttribute(SessionConstant.SYS_USER, user);

	}

	public static String getSessionId() {
		if (Objects.isNull(UserUtils.getRequest())) {
			return null;
		}
		return UserUtils.getRequest().getSession().getId();
	}
	
	public static void main(String[] args) {
		try {
			String url = "/contractList?_ly_=0";
			System.out.println(URLEncoder.encode(url, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
