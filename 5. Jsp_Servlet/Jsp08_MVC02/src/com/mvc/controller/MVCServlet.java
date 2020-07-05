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

import com.mvc.model.biz.MVCBiz;
import com.mvc.model.biz.MVCBizImpl;
import com.mvc.model.dao.MVCDao;
import com.mvc.model.dao.MVCDaoImpl;
import com.mvc.model.dto.MVCDto;


@WebServlet("/MVCServlet")
public class MVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MVCServlet() {
        // web.xml에서 controller.do를 통해 MVCServlet이 요청을 처리하도록 하자
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		PrintWriter out = response.getWriter();

		MVCBiz biz = new MVCBizImpl();
		if(command.equals("list")){
			List<MVCDto> list = biz.selectList();
			request.setAttribute("list", list);
			dispatch("boardlist.jsp",request,response);
		}if(command.equals("detail")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCDto dto = biz.selectOne(seq);
			request.setAttribute("dto",dto);
			dispatch("boarddetail.jsp", request, response);
			
		}if(command.equals("insert")) {
			response.sendRedirect("insertform.jsp");
		}if(command.equals("insertres")) {
			MVCDto dto = new MVCDto(0, request.getParameter("writer"), request.getParameter("title"), request.getParameter("content"),null);
			int res = biz.insert(dto);
		//	response.sendRedirect("controller.do?command=list");
			if(res > 0) {
				jsResponse("작성되었습니다.", "controller.do?command=list", response);
			}else {
				jsResponse("작성실패","controller.do?command=insert", response);
				
			}
		}if(command.equals("update")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCDto dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch("updateform.jsp", request, response);	
		}if(command.equals("updateres")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCDto dto = new MVCDto(seq, request.getParameter("writer"), request.getParameter("title"), request.getParameter("content"),null);
			int res = biz.update(dto);
			if(res > 0) {
				jsResponse("수정되었습니다.","controller.do?command=list",response);
			}else {
				jsResponse("수정 실패","controller.do?command=list",response);
			}
		}if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int res = biz.delete(seq);
			if(res > 0) {
				jsResponse("삭제되었습니다.","controller.do?command=list",response);
			}else {
				jsResponse("삭제 실패","controller.do?command=list",response);
			}
		}
		
		
		
		
		
		out.print("<h1 style='color:red;'>아 잘못왔다.<h1>");
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'>"+
					"alert('"+msg+"');"+
					"location.href='"+url+"';"+
					"</script>";
		
		response.getWriter().append(s);
	}
	
	

}
