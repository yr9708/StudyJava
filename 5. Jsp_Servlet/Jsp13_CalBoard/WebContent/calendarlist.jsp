<%@page import="com.cal.dto.CalDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 국제화 지역화 태그로 JSP 페이지에서 다양한 언어를 지원 받을 수 있고, 날짜와 숫자 형식을 다루는데 사용-->
 <% 
	request.setCharacterEncoding("UTF-8"); 
   	response.setContentType("text/html; charset=UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	
	$('input[name=chk]').on("click",function(){
		if($('input[name=chk]').length==$('input[name=chk]:checked').length){
			$('#all').prop("checked",true);
		}else{
			$("#all").prop("checked",false);
		}
	});
});
		
	function allChk(boo){
		var chks = document.getElementsByName("chk");
		for(var i =0; i<chks.length; i++){
			chks[i].checked = boo;
		}
	}
	
</script>
</head>
<body>
	<h1>일정 목록 보기</h1>
	<form action = "cal.do" method="post">
		<input type="hidden" name="command" value="muldel">
		<jsp:useBean id="utils" class="com.cal.util.Utils"/>
		
		<table border="1">
			<col width="50px">
			<col width="50px">
			<col width="300px">
			<col width="200px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" id="all" name="all" onclick="allChk(this.checked)"></th>
				<th>번  호</th>
				<th>제  목</th>
				<th>일  정</th>
				<th>작성일</th>
			</tr>
			
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="5" align='center'> 일정이 없습니다 </td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td align="center"><input type="checkbox" name="chk" value="${dto.seq }"></td>
							<td>${dto.seq }</td>
							<td><a href="cal.do?command=detail&seq=${dto.seq}">${dto.title }</a></td>
							<td>
								<jsp:setProperty property="toDates" name="utils" value="${dto.mdate }"/>
								<jsp:getProperty property="toDates" name="utils"/>
							</td>
							<td>
								<fmt:formatDate value="${dto.regdate }" pattern="yyyy:MM:dd"/>
								<%-- 날짜를 양식에 맞게 출력 --%>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="삭제">
					<input type="button" value="돌아가기" onclick="location.href='cal.do?command=calendar'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>