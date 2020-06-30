<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
   	response.setContentType("text/html; charset=UTF-8"); 
%>
<!DOCTYPE html>
<html>
<style type="text/css">
	table {
		border-collapse: collapse;
		width: 100%;
	}
	
	table th, table td {
		border-bottom: 1px solid #ddd;
		border-right: none;
    	border-left: none;
	}
</style>
<head>
<%
	MDBoardDao dao = new MDBoardDao();
	List<MDBoardDto> list = dao.selectList();
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script> <!-- latest : 가장최신버전 -->
<script type="text/javascript">
	$(function(){
		
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length==0){
				alert("하나 이상 체크하셔야 합니다.");
				return false; /* 이벤트 전파 막기 */
			}
		});
		
		$('input[name=chk]').on("click",function(){
			if($("input[name=chk]").length == $("input[name=chk]:checked").length){
				$('#all').prop("checked",true);
			} else {
				$('#all').prop("checked",false);
			}
		});
	});
	
	function allChk(bool){
		var chks = document.getElementsByName("chk");
		for(var i=0; i<chks.length; i++){
			chks[i].checked = bool;
		}
	}



</script>
</head>
<body>
	<%@ include file ="./form/header.jsp" %> <!-- < %@ 해당페이지의 설정들을 사용할 수 있다 -->
	<h1>글 목록</h1>
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30">
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
			<tr>
				<th><input type="checkbox" name="all" id ="all" onclick="allChk(this.checked);"></th>
				<th>번  호</th>
				<th>작성자</th>
				<th>제  목</th>
				<th>작성일</th>
			</tr>
<% 
	if(list.size() == 0){	
%>		
			<tr>
				<td colspan="5">-----글이 존재하지 않습니다.-----</td>
			</tr>
<%
	} else {
		for(MDBoardDto dto : list){
%>	
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="selectone.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
		}
	}
%>		<tr>
			<td colspan="5" align="right">
				<input type="button" value="글작성" onclick="location.href='boardinsert.jsp'"/>
				<input type="submit" value="선택글 삭제"/>
			</td>
		</tr>
		</table>
	</form>
	<%@ include file ="./form/footer.jsp" %>
</body>
</html>