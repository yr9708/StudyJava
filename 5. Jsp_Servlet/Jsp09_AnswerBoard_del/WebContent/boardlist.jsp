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
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#chkdelform").submit(function(){
			if($("#chkdelform input:checked").length == 0){
				alert("한개 이상 체크해주세요");
				return false;
			}
		});
			
		$('input[name=chk]').on("click",function(){
			if($('input[name=chk]').length == $('input[name=chk]:checked').length){
				$('#all').prop('checked',true);
			}else{
				$('#all').prop('checked',false);
			}
		});
			
			
	});
	
	function allChk(bool){
		var chks = document.getElementsByName("chk");
		for(var i =0; i<chks.length; i++){
			chks[i].checked = bool;
		}
	}
	
</script>
</head>
<body>
	<%@ include file ="./form/header.jsp" %> 
	<h1>📚글 목록📚</h1>
	<form action="answer.do" method="post" id="chkdelform">
	<input type="hidden" name="command" value="chkdel">
		<table border="1" style="border-collapse:collapse">
			<col width="30">
			<col width="50">
			<col width="300">
			<col width="100">
			<col width="100">
			<tr>
				<th><input type="checkbox" id="all" name="all" onclick="allChk(this.checked);"></th>
				<th>번  호</th>
				<th>제  목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4">작성된 글이 존재하지 않습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<c:choose>
							<c:when test="${dto.delflag eq 'Y' }">
								<tr>
									<td colspan="5" align="center">삭제된 글입니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td align="center"><input type="checkbox" id="chk" name="chk" value="${dto.boardno }"></td>
									<td align="center">${dto.boardno }</td>
									<td>
										<c:forEach begin="1" end="${dto.titletab }">
											&nbsp;
										</c:forEach>
										<a href="answer.do?command=selectOne&boardno=${dto.boardno }">${dto.title }</a>
									</td>
									<td>${dto.writer }</td>
									<td>${dto.regdate }</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5" align="right">
					<input type="button" value="글작성" onclick="location.href='answer.do?command=insertform'">
					<input type="submit" value="삭제">
				</td>
			</tr>
		</table>
	</form>
		<%@ include file ="./form/footer.jsp" %>
</body>
</html>