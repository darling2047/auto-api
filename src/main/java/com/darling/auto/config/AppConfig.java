package com.darling.auto.config;

import com.darling.auto.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public TokenInterceptor tokenInterceptor() {
		return new TokenInterceptor();
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**")
			.excludePathPatterns("/system/login/**",
					"/api/**",
					"/apiInfo/testCache",
					"/html/**",
					"/images/**",
					"/common/**",
					"/css/**",
					"/js/**",
					"/lib/**",
					"/page/**",
					"/index.html",
					"/*");
	}
	
}
