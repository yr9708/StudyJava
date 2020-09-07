package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 	클라이언트에서 서버로 넘어올 때 Filter가 몇개가 있을 수 있다 filter다음에 filter가 있으면 연결해주는 것이 FilterChain 이다.
		*/
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : " + remoteAddr + "\n") //본인의 시스템ip 주소를 반환하는데 127.0.0.1이 아닌 IPv6형태로 반환
			.append("* uri : " + uri + "\n") // 프로젝트 + 파일경로 가져오기
			.append("* url : " + url + "\n") // 전체경로 가져오기
			.append("* queryString : " + queryString + "\n") 
			.append("* referer : " + referer + "\n") // 이전 페이지(보내는,요청하는 페이지)의 url
			.append("* agend : " + agent); // 사용자 정보 (browser, or, 등등)
		
		System.out.println("LogFilter");
		System.out.println(sb);
		
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {

	}

}
