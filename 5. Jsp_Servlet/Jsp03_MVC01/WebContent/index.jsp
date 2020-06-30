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
<body> <!-- command 는 내 페이지에서 다른 페이지로 가고 싶어 라고 알려주는 변수. (다른 이름으로 써도 됨) -->
	<h1><a href="boardcontroller.jsp?command=list" style="text-decoration:none; color:black; font-weight:bold">🍺list🍺</a></h1>
</body>
</html>