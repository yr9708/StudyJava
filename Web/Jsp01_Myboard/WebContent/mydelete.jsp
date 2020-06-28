<%@page import="com.my.model.dao.MyDao"%>
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
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyDao dao = new MyDao();
	int result = dao.delete(myno);
	
	if(result > 0){
%>
	<script type="text/javascript">
		alert("삭제 완료");
		location.href="mylist.jsp"
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("삭제 실패");
		location.href="myselect.jsp?myno=<%=myno%>"
	</script>
<%
	}
%>
<body>
</body>
</html>