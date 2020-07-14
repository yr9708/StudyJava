<%@page import="com.my.model.dto.MyDto"%>
<%@page import="java.util.List"%>
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
<body>

<%
	MyDao dao = new MyDao();
	List<MyDto> list = dao.selectList();
%>
	<h1>글 목록</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th style="width:300px">제목</th>
			<th>날짜</th>
		</tr>
<%
	for(int i=0; i<list.size(); i++){
%>
		<tr id="ho">
			<td style="text-align:center;"><%=list.get(i).getMyno() %></td>
			<td><%=list.get(i).getMyname() %></td>
			<td><a href="myselect.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
			<td><%=list.get(i).getMydate() %></td>
		</tr>
<%			
		}
%>

		<tr id="ho2">
			<td colspan="4" align="right">
				<input type="button" value="글쓰기" onclick="location.href='myinsert.jsp'"/>
			</td>
		</tr>
	</table>
</body>

<style type="text/css">
	table th{
		padding-top:8px;
		padding-bottom:8px;
		text-align:center;
		background-color:#CBDCDF;
		color:white;
		
	}
	
	table{
		border-collapse:collapse;
		width:100%;
	}
	
	table td, table th{
		border-bottom: 1px solid #ddd;
		padding: 8xp;
	}
	
	table:nth-child(2){
		text-align:center;

	}
	
	#ho:hover{
		background-color:#ddd;
	}
	
	#ho2 td{
		border-bottom:none;
	}

	input[type=button]{
		background-color:white;
		border:1px solid #ddd;
	}
	
	a{
		text-decoration:none;
	}
	
	a:visited{
		color:gray;
	}
	
</style>
</html>