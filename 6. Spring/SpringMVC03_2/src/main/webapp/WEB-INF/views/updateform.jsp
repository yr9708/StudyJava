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
	<h1> U P D A T E </h1>
	<form action="update.do" method="post">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><input type="text" name='myname' value='${dto.myname }'></td>
			<tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			<tr>
			<tr>
				<th>CONTNET</th>
				<td><textarea cols="60" rows="10" name="mycontent">${dto.mycontent }</textarea></td>
			<tr>
			<tr>
				<th colspan="4" align="right">
					<input type="hidden" name="myno" value="${dto.myno }">
					<input type="button" value="목록" onclick="location.href='list.do'">
					<input type='submit' value="수정완료">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>