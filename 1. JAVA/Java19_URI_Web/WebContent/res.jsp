<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1><%=request.getParameter("myname")%> 님의 주소는 <%=request.getParameter("myaddr")%> 입니다.</h1>

</body>
</html>