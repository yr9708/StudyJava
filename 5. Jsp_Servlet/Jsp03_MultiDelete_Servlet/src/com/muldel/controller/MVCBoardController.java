package com.muldel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mudel.dao.MVCBoardDao;
import com.muldel.dto.MVCBoardDto;

@WebServlet("/MVCBoardController")
public class MVCBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		MVCBoardDao dao = new MVCBoardDao();
		if(command.equals("list")) {
			List<MVCBoardDto>list = dao.selectList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);	
		}else if(command.equals("muldel")) {
			String[] seqs =	request.getParameterValues("chk");
			PrintWriter out = response.getWriter();
			if(seqs == null || seqs.length == 0) {
				System.out.println("seqs가 들어온게없어");
				response.sendRedirect("controller.do?command=list");
			}else {
				int res = dao.multiDelete(seqs);
				if(res > 0) {
					out.print("<script>alert('삭제성공'); location.href='controller.do?command=list';</script>");
					out.flush();
				/*	response.sendRedirect("controller.do?command=list");*/
				}else {
					out.print("<script>alert('삭제실패'); location.href='controller.do?command=list';</script>");
					out.flush();
				}
			}
		}else if(command.equals("write")) {
			response.sendRedirect("writerform.jsp");
		}else if(command.equals("writeres")) {
			String writer = request.getParameter("writer");
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
