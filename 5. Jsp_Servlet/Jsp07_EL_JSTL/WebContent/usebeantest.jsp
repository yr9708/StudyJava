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
	<!-- javaBean : getter/setter를  -->
	<h1>useBean</h1>
	
	<!-- Score sc = new Score(); -->
	<!-- 기본적으로 scope는 page 이다. -->
	<jsp:useBean id ="sc" class="com.my.score.Score" scope="session"></jsp:useBean>
	<!-- sc.setName("홍길동"); -->
	<jsp:setProperty property="name" name="sc" value="홍길동"/>
	<jsp:setProperty property="kor" name="sc" value="100"/>
	<jsp:setProperty property="eng" name="sc" value="55"/>
	<jsp:setProperty property="math" name="sc" value="40"/>
	
	<!-- sc.getName(); -->
	<jsp:getProperty property="name" name="sc"/>
	<jsp:getProperty property="kor" name="sc"/>
	<jsp:getProperty property="eng" name="sc"/>
	<jsp:getProperty property="math" name="sc"/>
	<button onclick="location.href='res.jsp'">res</button>
</body>
</html>