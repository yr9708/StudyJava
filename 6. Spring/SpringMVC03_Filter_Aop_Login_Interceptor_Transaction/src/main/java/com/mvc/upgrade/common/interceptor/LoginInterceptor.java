package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest
;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[LoginInterceptor] : preHandler");
		
		// spring 3.2 이상부터는 servlet-context.xml에서 <exculude-mapping-path>를 통해 설정할 수 있다.
		if(request.getRequestURI().contains("/loginform.do") 
				|| request.getRequestURI().contains("/ajaxlogin.do") 
				|| request.getSession().getAttribute("login") != null 
				|| request.getRequestURI().contains("/test.do"))  { //이 조건 일때만 Controller로 넘어갈 수 있게끔 해준다.
			return true;
		} 
		
		
//		if(request.getRequestURI().contains("/ajaxlogin.do")) {
//			if(isAajxRequest(request)) {
//				logger.info("ajaxlogin??????");
//				return true;
//			}
//		}

		/*
		 * dispatcherServlet과 Controller 사이에 interceptor가 있다.
		 * 
		 */
		
		if(request.getSession().getAttribute("login") == null) {
			// 로그인이 안되어있다면
			response.sendRedirect("loginform.do");
			return false;
		}
		return false;
		
		
	}

	// DS -> C ->(ModelAndView)-> DS
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[LoginInterceptor] : postHandler");
	//	logger.info(modelAndView.getViewName()); // request에서 response될때 modelAndView가 없잖아 (ajax로 올때) 그러니까 null 이지
		if(modelAndView != null) {
			logger.info(modelAndView.getViewName());
		}

	}

	// 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[LoginInterceptor] : afterCompletion");
		
	}
	
//	private boolean isAajxRequest(HttpServletRequest req) {
//		String header = req.getHeader("AJAX");
//		if("true".equals(header)) {
//			return true;
//		}else {
//			return false;
//		}
//	}

}
