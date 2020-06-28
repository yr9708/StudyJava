<%@page import="com.my.model.dto.MyDto"%>
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
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyDao dao = new MyDao();
	int result = dao.insert(new MyDto(myname,mytitle,mycontent));
	
	if(result > 0){
%>
	<script type="text/javascript">
		alert("입력 완료!");
		location.href="mylist.jsp";
	</script>
<%
	} else {	
%>
	<script type="text/javascript">
		alert("전송 실패!")
		location.href="myinsert.jsp";
	</script>
<%
	}
%>
<body>

</body>
</html>