<%@page import="com.my.score.Score"%>
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
<%
	Score sc = (Score)request.getAttribute("score");
%>
</head>
<body>
	<h1>Expression Language</h1>
	<table border="1">
		<tr>
			<th colspan="2">${score.name }님의 점수, <%=sc.getName() %></th> 
			<!--
			 pageContext->request->session->application 순서대로 객체 안에 score라는 객체가 있는지 확인
			 score.getName();
			  -->
		</tr>
		<tr>
			<th>국어</th>
			<td>${score.kor }</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${score.eng }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${score.math } </td>
		</tr>
		<tr>
			<th>총점</th>
			<td>${score.sum } , <%=sc.getSum() %></td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${score.avg }</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${score.grade }, <%=sc.getGrade() %></td>
		</tr>
	</table>
</body>
</html>