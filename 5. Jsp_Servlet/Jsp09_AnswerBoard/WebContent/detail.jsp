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
	<h1>DETAIL</h1>
	<table border="1"  style="border-collapse:collapse">
		<tr>
			<th>writer</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>content</th>
			<td><textarea cols="60" rows="10" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="button" value="답변" onclick="location.href='answer.do?command=answerform&boardno=${dto.boardno}'">
				<input type="button" value="삭제" onclick="location.href='answer.do?command=delete&boardno=${dto.boardno}'"/>
				<input type="button" value="목록" onclick="location.href='answer.do?command=list'">
				<input type="button" value="수정" onclick="location.href='answer.do?command=updateform&boardno=${dto.boardno}'">
			</td>
		</tr>
	</table>
</body>
</html>