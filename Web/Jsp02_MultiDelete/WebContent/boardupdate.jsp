<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
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
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDao();
	MDBoardDto dto = dao.selectOne(seq);
%>
<body>
	<form action="boardupdateres.jsp" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="10" cols="60" style="resize:none" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="완료">
					<input type="button" value="취소" onclick="location.href='selectOne.jsp?seq=<%=seq%>'">
					<input type="hidden" name="seq" value="<%=seq %>"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>