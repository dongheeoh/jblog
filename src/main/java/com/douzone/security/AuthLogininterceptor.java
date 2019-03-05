package com.douzone.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.mysite.service.UserService;
import com.douzone.mysite.vo.UserVo;

public class AuthLogininterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		UserVo userVo = userService.getUser(id,password);
		
		if(userVo == null){		
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		HttpSession session=request.getSession(true);
		session.setAttribute("authUser", userVo);
		System.out.println(userVo);
		response.sendRedirect(request.getContextPath()+"/");
		return false;
	}

}
