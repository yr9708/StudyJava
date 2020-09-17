<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>U P D A T E</h1>
<form action="update.do">
	<table  border="1" style="border-collapse: collapse;">
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" value="${dto.title }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${dto.writer }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="60" rows="10" name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="hidden" name="seq" value="${dto.seq }">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>