package com.cal.score;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/score.do")
public class CalScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = kor+eng+math;
		double avg = sum/3.0;
		
		// {"key":"value"}
		// simple-json-1.1.jar
		JSONObject obj = new JSONObject();
		obj.put("name",name);
		obj.put("sum",sum);
		obj.put("avg",avg);
		
		System.out.println("servlet에서 보내는 msg : "+obj.toJSONString()); 
		
		PrintWriter out = response.getWriter();
		out.println(obj.toJSONString()); // 현재 json객체를 json형태의 문자열로 전달해줌
		
	}

}
