package com.answer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.dto.AnswerDto;



@WebServlet("/answer.do")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		AnswerBiz biz = new AnswerBiz();
		
		if(command.equals("list")) {
			List<AnswerDto> list = biz.selectList();
			request.setAttribute("list", list);
			dispatch("answerlist.jsp",response,request);
		}else if(command.equals("detail")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("detail.jsp",response,request);
		}else if(command.equals("insertform")) {
			response.sendRedirect("insertform.jsp");
		}else if(command.equals("insert")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			AnswerDto dto = new AnswerDto(title,content,writer);
			int res = biz.insert(dto);
			if(res > 0) {
				jsResponse("작성되었습니다", "answer.do?command=list", response);
			}else {
				jsResponse("작성 실패", "answer.do?command=list", response);
			}
		}else if(command.equals("updateform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("updateform.jsp", response, request);
		}else if(command.equals("update")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			AnswerDto dto = new AnswerDto(boardno,title,content,writer);
			int res = biz.update(dto);
			if(res > 0){
				jsResponse("수정되었습니다", "answer.do?command=list", response);
			}else {
				jsResponse("수정 실패", "answer.do?command=updateform&boardno="+boardno, response);
			}
		}else if(command.equals("delete")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			int res = biz.delete(boardno);
			if(res > 0) {
				jsResponse("삭제되었습니다", "answer.do?command=list", response);
			}else {
				jsResponse("삭제 실패", "answer.do?command=detail&boardno="+boardno, response);
			}
		}else if(command.equals("answerform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch("answerform.jsp", response, request);
		}else if(command.equals("answer")) {
			int parentboardno = Integer.parseInt(request.getParameter("parentboardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			AnswerDto dto = new AnswerDto(parentboardno, title, content, writer);
			int res = biz.answerProc(dto);
			if(res > 0) {
				jsResponse("답변작성 성공", "answer.do?command=list", response);
			}else {
				jsResponse("답변작성 실패", "answer.do?command=answerform%boardno="+parentboardno, response);
			}
		}
			
		response.getWriter().append("<h1>잘못왔네 아이구<h1>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void dispatch(String url, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request,response);
	}
	
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'>"+
					"alert('"+msg+"');"+
					"location.href='"+url+"';"+
					"</script>";
		
		response.getWriter().append(s);
	}
	

}
