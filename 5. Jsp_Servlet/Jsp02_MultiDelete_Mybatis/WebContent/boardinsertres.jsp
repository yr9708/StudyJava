<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
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
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MDBoardDao dao = new MDBoardDao();
	int result = dao.insert(new MDBoardDto(0, writer, title, content, null));

	if(result > 0){
%>
	<script type="text/javascript">
		alert("작성 성공하였습니다.");
		location.href="boardlist.jsp"
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("작성 실패ㅠㅜ");
		location.href="boardlist.jsp";
	</script>
<%
	}
%>
<body>
	
</body>
</html>