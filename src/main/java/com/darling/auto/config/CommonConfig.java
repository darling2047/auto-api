package com.darling.auto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 公共配置项
 * @author t-xiabin
 *
 */
@Configuration
@ConfigurationProperties("common")
public class CommonConfig {

	/**是否需要登录(0:否,1:是)*/
	private static Integer needLogin;


	public static Integer getNeedLogin() {
		return needLogin;
	}

	@Value("${common.need-login}")
	public void setNeedLogin(Integer needLogin) {
		CommonConfig.needLogin = needLogin;
	}



}
