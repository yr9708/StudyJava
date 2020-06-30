<%@page import="java.io.PrintWriter"%>
<%
	response.setHeader("Pragma", "no-cache"); 		// http 1.0
	response.setHeader("Cache-control","no-store");	// http 1.1
	response.setHeader("expires","0");				// proxy server
	/*
		서버가가지고 있던 캐시를 저장하지 않겠다 (캐시 : 잠깐 저장해놓는것)
		캐시가 있으면 속도는 빨라진다 (이미 저장되어있던것을 뿌려주니까)
		단점 : 캐시를 삭제하면 이미 저장되어있던 것이 사라지니까 500에러가 난다
		
		데이터가 변경 되었을 때, 이전 내용을 화면에 보여주는 이유
		-> 서버에서 다시 응답하는게 아니라 캐시에 저장된 내용을 가져오기 때문
		
		우리는 http 1.1 사용중
		
	*/
%>
<%@page import="com.login.dto.MyMemberDto"%>
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
	MyMemberDto dto = (MyMemberDto)session.getAttribute("dto");
	PrintWriter outer = response.getWriter(); // logicontroller.jsp에서 받아온 session
	
	if(dto == null){
		outer.println("<script> alert('로그인을 확인해주세요'); location.href='index.jsp'</script>");
		outer.flush(); // outer에 담겨있는 내용 비우기
		
		/* pageContext.forward("index.jsp"); */

	}
%>



<body>
	<h1><%=dto.getMyname() %>님 환영합니다.</h1>
	<div>
		<span>등급 : <%=dto.getMyrole() %></span><br/>
		<a href="logincontroller.jsp?command=logout">logout</a>
	</div>
	<div>
		<div>
			<a href="logincontroller.jsp?command=userlistall">회원 정보 전체조회</a>
		</div>
		<div>		
			<a href='logincontroller.jsp?command=userlisten'>회원 정보 조회 (myenabled = y) </a>
		</div>
	</div>
</body>
</html>