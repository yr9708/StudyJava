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
	<!-- jsp:useBean 사용하기 (el 금지) -->
	<jsp:useBean id="dto" class="com.mvc.model.dto.MVCDto" scope="request"></jsp:useBean>
	<form action="controller.do" method="post">
	<input type="hidden" name="command" value="update">
	<input type="hidden" name="seq" value="<jsp:getProperty property='seq' name='dto'/>">
	<table border="1"  style="border-collapse:collapse">
		<tr>
			<th>작성자</th>
			<td><jsp:getProperty property="writer" name="dto"/></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<jsp:getProperty property="title" name="dto"/>
			</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>
				<textarea rows="10" cols="60" name="content" style="resize:none"><jsp:getProperty property="content" name="dto"/></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<input type="button" value="목록" onclick="location.href='controller.do?command=list'"/>
				<input type="submit" value="수정"/>
				<input type="button" value="삭제" onclick="location.href='controller.do?command=delete&seq='+<jsp:getProperty property='seq' name='dto'/>"/>
			</td>
		</tr>
	</table> 
	</form>
</body>
</html>