<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);		
	}
</script>
</head>
<body>
	<h1>D E T A I L</h1>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제  목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내  용</th>
			<td>${dto.mycontent }</td>
		</tr>
		<tr>
			<th colspan="4" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'">
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'">
			</th>
		</tr>		
	</table>
</body>
</html>