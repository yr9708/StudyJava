<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 GETCMD 라네</h1>
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>GRADE</th>
			<th>CLASSNAME</th>
		</tr>
		
<%-- 		<tr>
			<td>${dto.name }</td>
			<td>${dto.grade }</td>
			<td>${dto.className }</td>
		</tr> --%>
		
 		<c:forEach items="${list}" var="student">
			<tr>
				<td>${student.name }</td>
				<td>${student.grade }</td>
				<td>${student.className }</td>
			<tr>
		</c:forEach> 
	</table>
</body>
</html>