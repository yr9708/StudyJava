<%@page import="com.login.dto.MyMemberDto"%>
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
	MyMemberDto dto = (MyMemberDto)request.getAttribute("dto");
%>
<body>
	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="userupdateres">
		<table>
		<tr>
			<th>번  호</th>
			<td><input type="text" name="myno" value="<%=dto.getMyno() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=dto.getMyid() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="mypw" value="<%=dto.getMypw() %>"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="myaddr" value="<%=dto.getMyaddr() %>"></td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><input type="text"  name="myphone" value="<%=dto.getMyphone() %>"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text"  name="email" value="<%=dto.getMyemail() %>"></td>
		</tr>
		<tr>
			<th>enabeld</th>
			<td><%=dto.getMyenabled() %></td>
		</tr>
		<tr>
			<th>myrole</th>
			<td><%=dto.getMyrole() %></td>
		</tr>
		<tr>
			<td colspan="8" align="right">
				<input type="submit" value="수정">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>