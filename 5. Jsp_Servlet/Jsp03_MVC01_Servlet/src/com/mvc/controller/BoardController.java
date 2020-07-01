package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.dao.MVCBoardDao;
import com.mvc.model.dto.MVCBoardDto;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.printf("[%s]\n",command);
		
		MVCBoardDao dao = new MVCBoardDao();
		if(command.equals("list")) {
			List<MVCBoardDto> list = dao.selectList();
			request.setAttribute("list", list);
			RequestDispatcher dispatch = request.getRequestDispatcher("boardlist.jsp");
			dispatch.forward(request, response);					
		}else if(command.equals("detail")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = dao.selectOne(seq);
			request.setAttribute("dto", dto);
			RequestDispatcher dp = request.getRequestDispatcher("detail.jsp");
			dp.forward(request, response);
		}else if(command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = dao.selectOne(seq);
			request.setAttribute("dto", dto);
			RequestDispatcher dp = request.getRequestDispatcher("updateform.jsp");
			dp.forward(request, response);
		}else if(command.equals("updateres")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			int res = dao.update(dto);
			if(res > 0) {
				RequestDispatcher dp = request.getRequestDispatcher("detail.jsp");
				request.setAttribute("dto", dao.selectOne(dto.getSeq()));
				dp.forward(request,response);
			}else {
				RequestDispatcher dp = request.getRequestDispatcher("updateform.jsp");
				request.setAttribute("dto", dao.selectOne(dto.getSeq()));
				dp.forward(request,response);
			}
		}else if(command.equals("write")) {
			response.sendRedirect("writeform.jsp");
			
		}else if(command.equals("writeres")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
			int res = dao.insert(dto);
			if(res > 0) {
				/*
				request.setAttribute("list", dao.selectList());
				RequestDispatcher dp = request.getRequestDispatcher("boardlist.jsp");
				dp.forward(request, response);
				 --> 작성완료된 상태로 새로고침을 누르면 계속해서 insert가 된다. 
				 	 forward된 list에 command=writers,writer=1,title=1,content=1 가 계속 살아 있기 때문에
				*/
				response.sendRedirect("controller.do?command=list");
			}else {
				response.sendRedirect("boardwriter.jsp");
			}
		}else if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int res = dao.delete(seq);
			PrintWriter out = response.getWriter();
			
			if(res > 0) {
				
				out.println("<script type='text/javascript'>alert('삭제 되었습니다'); location.href='controller.do?command=list';</script>");
				out.flush(); 
				
				/*
				 request.setAttribute("list", dao.selectList()); 
				 RequestDispatcher dp = request.getRequestDispatcher("boardlist.jsp"); 
				 dp.forward(request, response);
				 */
				 
			}else {
				// 삭제 실패되었습니다 알람 띄우고 싶다.
				out.println("<script>alert('삭제 실패'); location.href='controller.do?command=list';</script>");
				out.flush();
				/*
				 request.setAttribute("list", dao.selectList()); 
				 RequestDispatcher dp = request.getRequestDispatcher("boardlist.jsp"); 
				 dp.forward(request, response);
				 */
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
