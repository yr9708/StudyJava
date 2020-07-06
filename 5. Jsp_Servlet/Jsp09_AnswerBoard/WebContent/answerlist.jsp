<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
	<h1>게시판 목록</h1>
	<table border="1" style="border-collapse:collapse">
		<colgroup>
			<col width="50">
			<col width="300">
			<col width="150">
			<col width="100">
		</colgroup>
		<tr>
			<th>BoardNo</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Regdate</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">작성된 글이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
			<c:forEach items="${list }"  var="dto">
				<tr>
						<c:choose>
							<c:when test="${dto.boardno eq 0}">
								<td colspan="4" align="center">삭제된 글입니다.</td>
							</c:when>
							<c:otherwise>
								<td>${dto.boardno }</td>
							<c:forEach begin="1" end="${dto.titletab }">
								&nbsp;
							</c:forEach>
								<td>
									<a href="answer.do?command=detail&boardno=${dto.boardno }">${dto.title }</a>
								</td>
								<td>${dto.writer }</td>
								<td>${dto.regdate }</td>
							</c:otherwise>
						</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="글작성" onclick="location.href='answer.do?command=insertform'"/>
				</td>
			</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>