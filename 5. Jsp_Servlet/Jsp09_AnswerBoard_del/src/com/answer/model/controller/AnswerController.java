package com.answer.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.model.biz.AnswerBiz;
import com.answer.model.biz.AnswerBizImpl;
import com.answer.model.dto.AnswerDto;


@WebServlet("/answer.do")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		System.out.println("<"+command+">");
		
		AnswerBiz biz = new AnswerBizImpl();
		
		if(command.equals("list")) {
			List<AnswerDto>list = biz.selectList();
			request.setAttribute("list", list);
			dispatch("boardlist.jsp", request, response);
		}else if(command.equals("insertform")) {
			response.sendRedirect("insertform.jsp");
		}else if(command.equals("insertres")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			AnswerDto dto = new AnswerDto(0,title,content,writer);
			int res = biz.insert(dto);
			if(res > 0) {
				jsResponse("작성성공", "answer.do?command=list", response);
			}else {
				jsResponse("작성실패", "answer.do?command=insertform", response);
			}
		}else if(command.equals("selectOne")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("detail.jsp", request, response);
		}else if(command.equals("updateform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("updateform.jsp",request,response);
		}else if(command.equals("updateres")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			AnswerDto dto = new AnswerDto(boardno,title,content,null);
			int res = biz.update(dto);
			if(res > 0) {
				jsResponse("수정완료", "answer.do?command=list", response);
			}else {
				jsResponse("수정실패", "answer.do?command=list", response);
			}
		}else if(command.equals("answerform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("answerform.jsp",request,response);
		}else if(command.equals("answerres")) {
			int parentboardno = Integer.parseInt(request.getParameter("parentboardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			AnswerDto dto = new AnswerDto(parentboardno, title, content, writer);
			int res = biz.answerProc(dto);
			if(res >= 1) {
				jsResponse("답변 작성 성공", "answer.do?command=list", response);
			}else {
				jsResponse("답변 작성 실패", "answer.do?command=list", response);
			}
		}else if(command.equals("delete")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			int res = biz.delete(boardno);
			if(res>0) {
				jsResponse("삭제되었습니다", "answer.do?command=list", response);
			}else {
				jsResponse("삭제 실패", "answer.do?command=list", response);
			}
		}else if(command.equals("chkdel")) {
			String[] boardno = request.getParameterValues("chk");
			int res = biz.muldel(boardno);
			if(res > 0) {
				jsResponse("삭제되었습니다", "answer.do?command=list", response);
			}else {
				jsResponse("삭제실패", "answer.do?command=list", response);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'>"
				+ "alert('"+msg+"');"
				+ "location.href='"+url+"';"
				+ "</script>";
				
		response.getWriter().append(s);
				
	}

}
