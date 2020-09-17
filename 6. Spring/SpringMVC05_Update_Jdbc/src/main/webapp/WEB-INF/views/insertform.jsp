<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>I N S E R T</h1>
<form action="insert.do">
	<table  border="1" style="border-collapse: collapse;">
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="60" rows="10" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>