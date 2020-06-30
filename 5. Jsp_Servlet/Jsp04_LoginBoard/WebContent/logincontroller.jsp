<%@page import="java.util.List"%>
<%@page import="com.login.dto.MyMemberDto"%>
<%@page import="com.login.dao.MyMemberDao"%>
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
	String command = request.getParameter("command");
	System.out.println("<"+command+">");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		MyMemberDto dto = dao.login(myid, mypw);
		
		if(dto != null){ // 아이디,비번이 존재한다면
			// session scope에 담기
			session.setAttribute("dto",dto);
			//session 유효시간 : 10분동안 활동이 없으면 invalidate
			// dafault : 30분 
			// 음수일 때 무제한
			
			session.setMaxInactiveInterval(10*60);
			
			if(dto.getMyrole().equals("ADMIN")){
				// 서버가 응답하다가 adminmain 페이지로 다시 요청한 것(request객체가 다시 만들어지는 것)
				response.sendRedirect("adminmain.jsp");
			} else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			} 
			
		} else {
%>
	<script type="text/javascript">
		alert("로그인 실패");
		location.href="index.jsp";
	</script>
<%				
		}
	} else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
	} else if(command.equals("idcheck")){
		// 1. 받아줄 데이터 확인
		String id = request.getParameter("id");
		// 2. DB에 연결해서 값을 저장하던 가져오던 확인
		MyMemberDto dto = dao.idCheck(id);
		boolean idnotused = true;
		if(dto.getMyid() != null){ // dao에서 어떻게 초기값을 주느냐에 따라서 원하지 않는 에러가 날 수 잇다. 지금은 무조건 dto가 null 이 아니다(dao에 dto초기값을 생성해줬기 때문에)
			idnotused = false;
		}
		// 3. 보낼 데이터 있으면 request에 저장하기
		
		// 4. 보내기
		response.sendRedirect("idcheck.jsp?idnotused="+idnotused);
	}else if(command.equals("registres")){
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MyMemberDto dto = new MyMemberDto(0, myid, mypw, myname, myaddr, myphone, myemail, null ,null);
	
		boolean res = dao.insertUser(dto);
		
		if(res){
%>
	<script type="text/javascript">
		alert("가입되었습니다.")
		location.href="index.jsp";
	</script>
<%			
		} else {
%>
	<script type="text/javascript">
		alert("가입 실패");
		location.href="registform.jsp";
	</script>

<%			
		}
		
	} else if(command.equals("logout")){
		// session 객체가 가진 값 삭제
		session.invalidate(); // 무효화
		response.sendRedirect("index.jsp");
	} else if(command.equals("userlistall")){
		List<MyMemberDto> list = dao.selectList();
		request.setAttribute("list", list);
		pageContext.forward("userlist.jsp");
		
	} else if (command.equals("userlisten")){
		//1.
		//2.
		List<MyMemberDto> list = dao.selectEnabeld();
		//3.
		request.setAttribute("enabled",list);
		//4.
		pageContext.forward("userlisten.jsp");
		
	} else if(command.equals("updateroleform")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		request.setAttribute("dto",dto);
		pageContext.forward("updaterole.jsp");
		
	} else if(command.equals("updateroleres")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		int res = dao.updateUserRole(myno, myrole);
		if (res > 0){
%>
	<script type="text/javascript">
		alert("회원등급 수정완료");
		location.href="logincontroller.jsp?command=userlisten";
	</script>
<%			
		} else {
%>
	<script type="text/javascript">
		alert("회원등급 수정실패");
		location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
	</script>
<%			
		}
		
	} else if(command.equals("detail")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		request.setAttribute("dto",dto);
		pageContext.forward("userinfo.jsp");
		
	} else if(command.equals("updateuser")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		request.setAttribute("dto",dto);
		pageContext.forward("userupdateform.jsp");
		
	} else if(command.equals("userupdateres")){
		int myno = Integer.parseInt(request.getParameter("myno"));
				
		String mypw = request.getParameter("mypw");
		String myemail = request.getParameter("myemail");
		String myphone = request.getParameter("myphone");
		String myaddr = request.getParameter("myaddr");
		MyMemberDto dto = new MyMemberDto(myno, null, mypw, null, myaddr, myphone, myemail, null, null);
		
		int res = dao.updateUser(dto);
		if(res > 0){
%>
	<script type="text/javascript">
		alert("수정 성공");
		location.href="logincontroller.jsp?command=detail&myno=<%=myno%>";
	</script>
<%
		} else {		
%>
	<script type="text/javascript">
		alert("수정 실패");
		location.href="logincontroller.jsp?command=detail&myno=<%=myno%>";
	</script>
<%
		}
	} else if (command.equals("deleteuser")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		int res = dao.deleteUser(myno);
		
		if(res > 0){
%>
	<script type="text/javascript">
		alert("탈퇴되었습니다.");
		location.href="index.jsp";
	</script>
<%			
		} else {
%>
	<script type="text/javascript">
		alert("탈퇴 실패");
		location.href="logincontroller.jsp?command=detail&myno=<%=myno%>";
	</script>
<%			
		}
		
	}
%>	
</body>
</html>