<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h1>LIST</h1>
	<table border="1">
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="300"/>
			<col width="100"/>
		</colgroup>
		<tr>
			<th>번  호</th>
			<th>작성자</th>
			<th>제  목</th>
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
						<td align="center">${dto.myno }</td>
						<td align="center">${dto.myname }</td>
						<td><a href="selectOne.do?myno=${dto.myno }">${dto.mytitle }</a></td>
						<td aling="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.mydate}"/></td>
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