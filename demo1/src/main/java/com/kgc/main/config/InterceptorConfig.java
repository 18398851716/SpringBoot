package com.kgc.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.kgc.main.interceptor.LoginInterceptor;
/**
 * 登录拦截器配置类
 * @author HH
 *
 */
@SpringBootConfiguration
public class InterceptorConfig extends WebMvcConfigurationSupport{
	/**
	 * 自动装配登录拦截器的实现类
	 */
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index","/code");
	}
}
