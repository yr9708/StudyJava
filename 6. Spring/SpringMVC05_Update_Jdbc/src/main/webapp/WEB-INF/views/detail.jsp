<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>D E T A I L</h1>
	<table  border="1" style="border-collapse: collapse;">
		<tr>
			<th>글제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="60" rows="10" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type="button" value="수정" onclick="location.href='updateform.do?seq=${dto.seq}'">
				<input type="button" value="삭제" onclick="location.href='delete.do?seq=${dto.seq}'">
			</td>
		</tr>
	</table>
</body>
</html>