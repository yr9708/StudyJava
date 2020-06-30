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
	MyDao dao  = new MyDao();
	MyDto dto = dao.selectOne(myno);
%>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<td><%=myno %></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><%=dto.getMytitle() %></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="20" cols="60" readonly="readonly" style="resize:none"><%=dto.getMycontent() %></textarea>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" onclick="location.href='myupdate.jsp?myno=<%=myno %>'" value="수정">
				<input type="button" onclick="location.href='mylist.jsp'" value="목록">
				<input type="button" onclick="checkDel(<%=myno %>);" value="삭제">
			</td>
		</tr>
	</table>
</body>

<script type="text/javascript">
	function checkDel(myno){
		if(confirm("삭제하시겠습니까?")){
			location.href='mydelete.jsp?myno='+myno;
		}
	}

</script>
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
	
	input[type=button]{
		background-color:white;
		border:1px solid #ddd;
	}
	
</style>

</html>