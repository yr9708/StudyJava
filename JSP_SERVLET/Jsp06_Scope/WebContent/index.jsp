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
	pageContext.setAttribute("pageId", "my pageId value!!");
	request.setAttribute("requestId", "my requestId value!!");
	session.setAttribute("sessionId", "my sessionId value!!"); // session은 invalidate전까지
	application.setAttribute("applicationId", "my applicationId value!!");
%>
	<h1>index</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %> <br/>
	requestId : <%=request.getAttribute("requestId") %> <br/>
	sessionId : <%=session.getAttribute("sessionId") %><br/>
	applicationId : <%=application.getAttribute("applicationId") %><br/>
	
	<a href="result.jsp?param=myrequestparamvalue">result...</a>
	<br>
	<a href="controller.do">controller🍓</a> 
  	<% pageContext.forward("controller.do"); %> 
</body>
</html>