<%@page import="com.muldel.dao.MDBoardDao"%>
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
	// name="chk"인 value값 여러개를 한번에 받아준다.
	// ?chk=1&chk=2&...
	// [1, 2, 3 ...]
	String[] seq = request.getParameterValues("chk");
	
	// 유효성 검사 
	// 이중보안
	if(seq == null || seq.length == 0){
%>
	<script type="text/javascript">
		alert("하나 이상 체크 해주세요");
		location.href="boardlist.jsp";
	</script>
<%		
	} else {
		MDBoardDao dao = new MDBoardDao();
		int res = dao.multiDelete(seq);
		if(res > 0){
		
%>
	<script type="text/javascript">
		alert("선택된 글들을 삭제 성공하였습니다.");
		location.href="boardlist.jsp";
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("선택된 글들을 삭제 실패하였습니다.");
		location.href="boardlist.jsp";
	</script>

<%
		}
	}
%>

</body>
</html>