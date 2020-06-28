<%@page import="java.util.List"%>
<%@page import="com.mvc.model.dto.MVCBoardDto"%>
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
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("list");
%>

	<h1>글 목록</h1>
	<table border="1">
		<col width="50">
		<col width="100">
		<col width="300">
		<col width="100">
		<tr>
			<th>번  호</th>
			<th>작성자</th>
			<th>제  목</th>
			<th>작성일</th>
		</tr>
<%
	if(list.size() == 0){
%>
	<tr>
		<td colspan="4">=====작성된 글이 존재하지 않습니다=====</td>
	</tr>
<%
	} else {
		for(MVCBoardDto dto : list){
%>
	<tr>
		<td><%=dto.getSeq() %></td>
		<td><%=dto.getWriter() %></td>
		<td><a href="boardcontroller.jsp?command=detail&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
		<td><%=dto.getRegdate() %></td>
	</tr>
<%
		}
	}
%>
	<tr>
		<td colspan="4" align="right">
			<input type="button" value="글작성" onclick="location.href='boardcontroller.jsp?command=insert'">
		</td>
	</tr>
	</table>

</body>
</html>