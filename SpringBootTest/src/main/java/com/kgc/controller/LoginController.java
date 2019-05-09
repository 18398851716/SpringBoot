package com.kgc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kgc.entity.User;
import com.kgc.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService us;
	
	@RequestMapping("/index")
	public String index() {
		return "login.jsp";
	}
	
	@RequestMapping("/regist")
	public String regist() {
		return "regist.html";
	}
	
	@RequestMapping("/login")
	public ModelAndView longin(HttpServletRequest req,HttpServletResponse pesp) throws Exception, IOException {
		ModelAndView mv = new ModelAndView();
		String uid = req.getParameter("uid");
		String pwd = req.getParameter("pwd");
		String code = req.getParameter("yzm").toLowerCase();
		String yzm = (String) req.getSession().getAttribute("code");
		User user = us.getUserById(Integer.parseInt(uid));
		if(!code.equals(yzm.toLowerCase())){
			req.setAttribute("msg", "您输入的验证码有误");
			req.getRequestDispatcher("/login.jsp").forward(req, pesp);
			return null;
		}else {
			if(user!=null) {
				if(user.getPassword().equals(pwd)) {
					req.getSession().setAttribute("user", user);
					mv.setViewName("main.jsp");
					return mv;
				}
				else {
					req.setAttribute("msg", "您输入的账号或密码有误");
					req.getRequestDispatcher("/login.jsp").forward(req, pesp);
					return null;
				}
			}else {
				req.setAttribute("msg", "您输入的账号或密码有误");
				req.getRequestDispatcher("/login.jsp").forward(req, pesp);
				return null;
			}
		}
	}
}
