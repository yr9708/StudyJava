<%@page import="java.util.Calendar"%>
<%@page import="com.cal.dto.CalDto"%>
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
<%
	CalDto dto = (CalDto) request.getAttribute("dto");

	int year = Integer.parseInt(dto.getMdate().substring(0,4));
	int month = Integer.parseInt(dto.getMdate().substring(4,6));
	int date = Integer.parseInt(dto.getMdate().substring(6,8));
	int hour = Integer.parseInt(dto.getMdate().substring(8,10));
	int min = Integer.parseInt(dto.getMdate().substring(10));
	

	Calendar cal = Calendar.getInstance();
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
%>
</head>
<body>
	<h1>UPDATE</h1>
	<form action="cal.do" method="post">
		<input type="hidden" name="command" value="updateres">
		<input type="hidden" name="seq" value="${dto.seq }">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" value="kh" readonly="readonly"></td>
			</tr>
			<tr>
				<th>일정</th>
				<td>
					<select name="year">
<%
						for(int i=year-5; i<=year+5; i++){
%>
						<option value="<%=i %>" <%=(year == i)?"selected":"" %>><%=i %></option>
<%
	}
%>
					</select>년
					<select name="month">
<%
				for(int i=1; i<13; i++){
%>
				<option value="<%=i %>" <%=(month==i)?"selected":"" %>><%=i %></option>
<%
				}
%>					
					</select>월
					<select name="date">
<%
				for(int i=1; i<=lastDay; i++){
%>
				<option value="<%=i%>" <%=(date==i)?"selected":"" %>><%=i %></option>
<%
				}
%>
					</select>일
					<select name="hour">
<%
				for(int i=1; i<24; i++){				
%>
				<option value="<%=i %>" <%=(hour==i)?"selected":"" %>><%=i %></option>
<%
				}
%>
					</select>시
					
					<select name='min'>
<%
				for(int i=1; i<60; i++){
%>
				<option value="<%=i %>"<%=(min==i)?"selected":"" %>><%=i %></option>
<%
				}
%>
					</select>분
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${dto.title }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="content" style="resize:none;">${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="돌아가기" onclick="location.href='cal.do?command=calendar'"/>
				</td>
			<tr>
		</table>
	</form>	
</body>
</html>