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
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDao();
	int result = dao.delete(seq);
	
	if(result > 0){
%>
	<script type="text/javascript">
		alert("삭제되었습니다.")
		location.href="boardlist.jsp";
	</script>
	
<%
	} else {
%>
	<script type="text/javascript">
		alert("삭제 실패");
		location.href="selectone.jsp?seq=<%=seq%>";
	</script>
<%
	}
%>
<body>

</body>
</html>