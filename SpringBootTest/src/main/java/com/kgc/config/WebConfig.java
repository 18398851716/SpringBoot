package com.kgc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kgc.interceptor.LoginInterceptor;
/**
 * 拦截配置
 * @author HH
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor li;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(li).addPathPatterns("/**").excludePathPatterns("/index","/login","/ValidateCode.jpg");
	}
}
