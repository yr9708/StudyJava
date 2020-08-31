<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 POSTCMD 라네</h1>
	<table border=1">
		<tr>
			<td>NAME</td>
			<td>GRADE</td>
			<td>CLASSNAME</td>
		</tr>
		<tr>
			<td>${student.name }</td>
			<td>${student.grade }</td>
			<td>${student.className }</td>
		</tr>	
	</table>
	
	${student.name } : ${student.grade }학년이 웃겨?
</body>
</html>