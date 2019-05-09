package com.kgc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kgc.servlet.RoomUser;

@Configuration
public class ServletConfig {
	@Autowired
	private RoomUser ru;
	
	@Bean
	public ServletRegistrationBean<RoomUser> servletRegistrationBean(){
		return new ServletRegistrationBean<>(ru,"/RoomUser");
	}
}
