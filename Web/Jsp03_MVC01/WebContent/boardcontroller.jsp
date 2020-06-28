<%@page import="com.mvc.model.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.model.biz.MVCBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
   	response.setContentType("text/html; charset=UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// scriptlet
	String command = request.getParameter("command");
	System.out.println("<"+command+">");
	
	MVCBoardBiz biz = new MVCBoardBiz();
	
	if(command.equals("list")){
		List<MVCBoardDto> list = biz.selectList();
		request.setAttribute("list",list);
		pageContext.forward("boardlist.jsp");
	}
	/*
		pageContext : 해당페이지와 일대일로 연결된 객체를 의미
		forward : 지정한 상대경로 페이지로 이동
		include : 지정한 상대경로 페이지를 현재 jsp페이지에 포함
	*/
	
	if(command.equals("detail")){
		// 1. 전달된 값 받기
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2. db에서 값 가져오기
		MVCBoardDto dto = biz.selectOne(seq);
		// 3. 전달할 값 저장
		request.setAttribute("dto",dto);
		// 4. 화면 전환
		pageContext.forward("boarddetail.jsp");
		
	} else if(command.equals("update")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int res = biz.update(new MVCBoardDto(seq, title, content));
		
		if(res > 0){
%>			
	<script type="text/javascript">
		alert("글 수정 성공")
		location.href="boardcontroller.jsp?command=detail&seq=<%=seq%>";
	</script>
<%
		} else {
%>
	<script type="text/javascript">
		alert("글 수정 실패")
		location.href="boardcontroller.jsp?command=list";
	</script>
<%	
		} 
	} else if(command.equals("insert")){

		// 응답하다가 다시 요청해라 
		// 데이터를 전달하지 않을때는 sendRedirect
		// 데이터를 담아서 보낼 때는 forward
		response.sendRedirect("boardwriter.jsp");
		
	} else if(command.equals("insertChk")){
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int res = biz.insert(new MVCBoardDto(writer,title,content));
		
		if(res > 0){
%>			
		<script type="text/javascript">
			alert("작성 성공");
			location.href="boardcontroller.jsp?command=list";
		</script>
		
<%
		} else {
%>		
		<script type="text/javascript">
			alert("작성 실패");
			location.href="boardcontroller.jsp?command=insert";
		</script>
<%
		}		
	} else if(command.equals("delete")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		int res = biz.delete(seq);
		if(res > 0){
%>			
	<script type="text/javascript">
		alert("글 삭제 성공")
		location.href="boardcontroller.jsp?command=list";
	</script>
<%
		} else {
%>			
	<script type="text/javascript">
		alert("글 삭제 실패")
		location.href="boardcontroller.jsp?command=detail&seq=<%=seq%>";
	</script>
<%
		}
	}
%>

<h1>&#129327;잘못왔다&#129327;</h1>
</body>
</html>