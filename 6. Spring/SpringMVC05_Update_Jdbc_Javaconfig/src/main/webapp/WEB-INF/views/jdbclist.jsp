<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List👻</h1>
	<table  border="1" style="border-collapse: collapse;">
		<colgroup>
			<col width="50">
			<col width="100">
			<col width="400">
			<col width="100">
		</colgroup>
		<tr>
			<th>no.</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4" align="center">작성된 글이 없습니다.</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td align="center">${dto.seq }</td>
						<td align="center">${dto.writer }</td>
						<td><a href="detail.do?seq=${dto.seq }">${dto.title }</a></td>
						<td align="center">${dto.regdate}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='insertform.do'">
			</td>
		</tr>
	</table>
</body>
</html>