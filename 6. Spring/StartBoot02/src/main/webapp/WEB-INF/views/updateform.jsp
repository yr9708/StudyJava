<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update</h1>
	<form action="update">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }" ></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" value="${dto.myname }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="hidden" value="${dto.myno }" name="myno">
					<input type="submit" value="수정">
					<input type="button" value="목록" onclick="location.href='list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>