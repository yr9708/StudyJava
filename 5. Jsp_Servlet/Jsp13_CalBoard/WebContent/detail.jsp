<%@page import="com.cal.dto.CalDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
	<h1>DETAIL</h1>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<th>일정</th>
			<td>
				<jsp:useBean id="utils" class="com.cal.util.Utils"/>
				<jsp:setProperty property="toDates" name="utils" value="${dto.mdate }"/>
				<jsp:getProperty property="toDates" name="utils"/>
			</td>
		</tr>
		<tr>
			<th>제  목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td><textarea cols="60" rows="10" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='cal.do?command=updateform&seq=${dto.seq}'">
				<input type="button" value="돌아가기" onclick="location.href='javascript:history.go(-1)'">
			</td>
		</tr>
		
	</table>
</body>
</html>