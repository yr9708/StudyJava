<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>I N S E R T</h1>
	<form action="insertBoard.do" method="POST">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>이 름</th>
				<td><input type="text" name="myname"></td>
			</tr>	
			<tr>
				<th>제 목</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea cols="60" rows="10"  name="mycontent"></textarea></td>
			</tr>
			<tr>
				<th colspan="4" align="right">
					<input type="button" value="목록" onclick="location.href='selectList.do'">
 					<input type="submit" value="등록">
					
				</th>
			</tr>	
		</table>
	</form>
</body>
</html>