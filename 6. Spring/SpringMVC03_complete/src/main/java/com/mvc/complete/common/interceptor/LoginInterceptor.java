package com.mvc.complete.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("[LoginInterceptor] : preHandler");
		
		if(request.getRequestURI().contains("/loginForm.do")||
			request.getRequestURI().contains("/ajaxlogin.do") ||
			request.getSession().getAttribute("login") != null ||
			request.getRequestURI().contains("/regist") ||
			request.getRequestURI().contains("/transactionTest.do")
			) {
			return true;
		}
		
		if(request.getSession().getAttribute("login")== null) {
			response.sendRedirect("loginForm.do");
			return false;
		}
		return false;
	}
	
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("[LoginInterceptor] : postHandle");
		
		if(modelAndView != null) {
			log.info(modelAndView.getViewName());
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("[LoginInterceptor] : afterCompletion");

	}

}
