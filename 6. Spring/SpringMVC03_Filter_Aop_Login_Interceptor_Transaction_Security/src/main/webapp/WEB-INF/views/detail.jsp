<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> D E T A I L</h1>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>NAME</th>
			<td>${dto.myname }</td>
		<tr>
		<tr>
			<th>TITLE</th>
			<td>${dto.mytitle }</td>
		<tr>
		<tr>
			<th>CONTNET</th>
			<td><textarea cols="60" rows="10" readonly="readonly">${dto.mycontent }</textarea></td>
		<tr>
		<tr>
			<th colspan="4" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type='button' value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'">
				<input type="button" value="삭제" onclick="location.href='deleteboard.do?myno=${dto.myno}'">
			</th>
		</tr>
	</table>
</body>
</html>