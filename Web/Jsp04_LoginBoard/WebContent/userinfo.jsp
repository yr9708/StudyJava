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
	<table border="1">
		<tr>
			<th>번  호</th>
			<td><%=dto.getMyno() %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=dto.getMyid() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=dto.getMypw() %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=dto.getMyaddr() %></td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><%=dto.getMyphone() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getMyemail() %></td>
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
				<input type="button" value="수정" onclick="location.href='logincontroller.jsp?command=updateuser&myno=<%=dto.getMyno() %>'">
				<input type="button" value="탈퇴" onclick="location.href='logincontroller.jsp?command=deleteuser&myno=<%=dto.getMyno() %>'">
			</td>
		</tr>
	</table>
</body>
</html>