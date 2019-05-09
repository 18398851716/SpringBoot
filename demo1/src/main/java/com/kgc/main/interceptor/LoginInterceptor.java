package com.kgc.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kgc.main.pojo.User;
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().println("请先登录！");
			return false;
		}else {
			return true;
		}
	}
}
