package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet") // annoation url패턴(/<-포함해서 꼭 써줘야함) 써주면 해당 패턴으로 요청이들어오면 그 타입의 객체를 만들어서 연결해줄게 
public class HelloServlet extends HttpServlet {
	// 직렬화 (찾아보기)
	private static final long serialVersionUID = 1L;

	private String initParameter;
	private String contextParameter;
	
    public HelloServlet() {
        System.out.println("Hello Servlet 생성!!");
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello Servlet init !!!");
		contextParameter = config.getServletContext().getInitParameter("url");
		System.out.println("contextParam : "+contextParameter);
		
		initParameter = config.getInitParameter("driver");
		System.out.println("initParam : "+initParameter);
	}


    // get 방식으로 넘어온 요청을 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 무조건 인코딩부터 하고 시작!!!!!!! 진짜진짜 중요!!!!
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	
		
		System.out.println("GET 방식으로 요청됨!");
		System.out.println("init Param :"+initParameter);
		
		String command = request.getParameter("command");
		System.out.println("<"+command+">");
		
		PrintWriter out = response.getWriter();
		out.append("<h1 style='background-color:dodgerblue;'>Hello Servlet</h1>");
		out.append("<h2>계층구조 / 라이프 사이클 / url 맵핑</h2>");
		out.append("<a href='home.html'>돌아가기</a>");

	}


	// post 방식으로 넘어온 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // 오타나면 다운로드 된다.
		
		System.out.println("POST 방식으로 들어옴!!");
		System.out.println("initParam : "+initParameter);
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		response.getWriter().append("<h1 style='background-color:pink;'>Hello Servlet</h1>")
							.append("<h2> 계층구조 / 라이프 사이클 / url 맵핑</h2>")
							.append("<a href='home.html'>돌아가기</a>");
	
	}

	@Override
	public void destroy() {
		System.out.println("servlet destroy!!!");
	}
}
