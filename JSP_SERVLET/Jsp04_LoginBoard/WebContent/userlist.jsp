<%@page import="com.login.dto.MyMemberDto"%>
<%@page import="java.util.List"%>
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
	List<MyMemberDto> list = (List<MyMemberDto>)request.getAttribute("list");

%>
<body>	
<h1>회원 정보 전체출력</h1>
	<table border="1"> 
		<tr>
			<th>번    호</th>
			<th>아 이 디</th>
			<th>이    름</th>
			<th>이 메 일</th>
			<th>현재등급</th>
		</tr>
<%
	if(list.size() == 0){
%>
	<tr>
		<td colspan="5">----가입된 회원 정보가 없습니다.----</td>
	</tr>	
<%
	} else {
		for(int i=0; i<list.size(); i++){
%>
	<tr>
		<td><%=list.get(i).getMyno() %></td>
		<td><%=list.get(i).getMyid() %></td>
		<td><%=list.get(i).getMyname() %></td>
		<td><%=list.get(i).getMyemail() %></td>
		<td><%=list.get(i).getMyrole() %></td>
	</tr>
<%
		}
	}
%>
	<Tr>
		<td colspan="5"><input type="button" onclick="location.href='index.jsp'" value="메인"></td>
	</Tr>
	</table>
</body>
</html>