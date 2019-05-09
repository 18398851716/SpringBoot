package com.kgc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dsna.util.images.ValidateCode;

@Controller
public class ValidateCodeController {
	
	@RequestMapping("ValidateCode.jpg")
	public void code(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setHeader("Cache-Control", "no-cache");
			ValidateCode vc = new ValidateCode(125, 20, 4, 14);
			String code = vc.getCode();
			req.getSession().setAttribute("code", code);
			vc.write(resp.getOutputStream());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
