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
<script type="text/javascript">
	function idcheck(){
		var doc = document.getElementsByName("myid")[0];
		if (doc.value.trim() == "" || doc.value == null){
			alert("아이디를 입력해주세요"); // 유효성 검사
		} else {
			open("logincontroller.jsp?command=idcheck&id="+doc.value,"","width=200, height=200");
		}
	}
</script>
</head>
<body>
<h1>회원가입</h1>
	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="registres">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="myid" required="required" title="n">
					<input type="button" value="중복체크" onclick="idcheck();"/>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="mypw" required="required"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="myname" required="required"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="myaddr" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="myphone" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="myemail" required="required"></td>
			</tr>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="가입">
					<input type="button" value="취소" onclick="loaction.href='index.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>