<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>R E G I S T</h1>
	<form action="registRes.do">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="memberpw"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="regist">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>