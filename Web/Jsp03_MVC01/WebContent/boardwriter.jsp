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
	<h1>글 작성</h1>
	<form action="boardcontroller.jsp" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>제  목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내  용</th>
				<td><textarea rows="10" cols="60" name="content" style="resize:none"></textarea></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="button" value="목록" onclick="location.href='boardcontroller.jsp?command=list'">
					<input type="submit" value="완료">
					<input type="hidden" name="command" value="insertChk">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>