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
	<form action="myinsertres.jsp" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="mytitle"></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent"></textarea>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="전송">
					<input type="button" onclick="location.href='mylist.jsp'" value="취소">
				</td>
			</tr>
		</table>
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