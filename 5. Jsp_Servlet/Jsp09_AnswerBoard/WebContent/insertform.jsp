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
	<h1>INSERT</h1>
	<form action="answer.do" method="post">
	<input type="hidden" name="command" value="insert">
	<table border="1"  style="border-collapse:collapse">
		<tr>
			<th>writer</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>title</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>content</th>
			<td><textarea cols="60" rows="10" name="content" style="resize:none"></textarea></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="button" value="목록" onclick="location.href='answer.do?command=list'">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>