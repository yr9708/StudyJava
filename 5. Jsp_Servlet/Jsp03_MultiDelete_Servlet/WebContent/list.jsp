<%@page import="com.muldel.dto.MVCBoardDto"%>
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
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
%>
		<h1>글 목록</h1>
	<form action="controller.do" method="post" id="muldelform">
	<input type="hidden" name="command" value="muldel">
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
		for(MVCBoardDto dto : list){
%>	
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="controller.do?command=detail&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
		}
	}
%>		<tr>
			<td colspan="5" align="right">
				<input type="button" value="글작성" onclick="location.href='controller.do?command=write'"/>
				<input type="submit" value="선택글 삭제"/>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>