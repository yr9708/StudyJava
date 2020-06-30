package com.scope.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		
		String requestId = (String) request.getAttribute("requestId");
		System.out.println("requestId: "+requestId);
		
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		System.out.println("sessionId : "+sessionId);
		
		ServletContext application = getServletContext();
		String applicationId = (String) application.getAttribute("applicationId");
		System.out.println("applicationId : "+applicationId);
		
		PrintWriter out = response.getWriter()
					.append("<h1>테이블 개노가다</h1>"
							+ "<table border='1'>"
							+ "<tr>"
							+ "<th>requestId</th>"
							+ "<td>"+requestId+"</td>"
							+ "</tr>"
							+ "<tr>"
							+ "<th>sessionId</th>"
							+ "<td>"+sessionId+"</td>"
							+ "</tr>"
							+ "<tr>"
							+ "<th>applicationId</th>"
							+ "<td>"+sessionId+"</td>"
							+ "</tr>"
							+ "</table>");
		
				
		
	}

}
