<%@page import="com.my.model.dto.MyDto"%>
<%@page import="com.my.model.dao.MyDao"%>
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
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyDao dao = new MyDao();
	MyDto dto = dao.selectOne(myno);
%>
<body>
<form action="myupdateres.jsp">
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="mytitle" value="<%=dto.getMytitle()%>"></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="10" cols="60" name="mycontent"><%=dto.getMycontent() %></textarea>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="수정">
				<input type="button" value="취소" onclick="location.href='myselect.jsp?myno=<%=dto.getMyno() %>'">
			</td>
		</tr>
	</table>
	<input type="hidden" name="myno" value="<%=dto.getMyno() %>">
</form>
</body>

<style type="text/css">
	table{
		border-collapse:collapse;
	}
	td, th{
		padding:8px;
	}
	
	th{
		background-color:#CBDCDF;
		color:white;
	}
	
	input[type=button],input[type=submit]{
		background-color:white;
		border:1px solid #ddd;
		
	}
	
</style>
</html>