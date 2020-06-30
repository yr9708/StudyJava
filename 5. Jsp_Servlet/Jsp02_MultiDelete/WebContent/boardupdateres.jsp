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
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	MDBoardDao dao = new MDBoardDao();
	int res = dao.update(new MDBoardDto(seq, null, title, content, null));
	 
	if(res > 0){
%>
	<script type="text/javascript">
		alert("수정되었습니다.")
		location.href="selectone.jsp?seq=<%=seq%>"
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("수정실패!");
		location.href="boardupdate.jsp?seq=<%=seq%>"
	</script>
<%
	}
%>
<body>
	
</body>
</html>