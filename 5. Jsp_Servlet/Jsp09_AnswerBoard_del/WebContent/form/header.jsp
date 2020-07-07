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
<style type="text/css">
	header{
		background-color:#CDCDE7;
		height:50px;
	}
	
	div {
		padding-top: 14px;
	    padding-bottom: 14px;
	    padding-left: 20px;
	    padding-right: 20px;
	}
	
	footer{
		background-color:#CDCDE7;
		height:30px;
		text-align:center;
		line-height:30px;
	}
	a{
		text-decoration:none;
		color:black;
	}
	
	a:visited{
		color:gray;
	}
	
	a:hover{
		color:red;
	}
	
	div>a {
		color:white;
		font-weight:bold;
	}
	
	div>a:visited{
		color:white;
	}
</style>
</head>
<body>
	<header>
		<div>
			<a href="answer.do?command=list">HOME</a>
		</div>
	</header>
</body>
</html>