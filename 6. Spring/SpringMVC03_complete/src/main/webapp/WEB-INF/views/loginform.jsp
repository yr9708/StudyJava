<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#loginchk").hide();
});

function loginPrc(){
	var memberid = $("#memberid").val().trim();
	var memberpw = $("#memberpw").val().trim();
	var loginVal = {
			"memberid" : memberid,
			"memberpw" : memberpw
	}
	
	if(memberid == null || memberid == "" || memberpw==null || memberpw==""){
		alert("ID와 PW를 확인해주세요");
	}else{
		$.ajax({
			type : "post",
			url : "ajaxlogin.do",
			data : JSON.stringify(loginVal),
			contentType : "application/json",
			dataType : "json",
			success : function(msg){
				if(msg.check==true){
					location.href="selectList.do";
				}else{
					$("#loginchk").show();
					$("#loginchk").html("ID 또는 PW가 잘못됐습니다.").css("color","red");
				}
			},
			error : function(){
				alert("연결 안됨");
			}
		});
	}
		
}
</script>
</head>
<body>
<h1>L O G I N</h1>
<table>
	<tr>
		<th>ID</th>
		<td><input type="text" id="memberid"></td>
	</tr>
	<tr>
		<th>PW</th>
		<td><input type="text" id="memberpw"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="Login" onclick="loginPrc();">
			<input type="button" value="Regist" onclick="location.href='registForm.do'">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" id="loginchk" style="color:red;"></td>
	</tr>
</table>
</body>
</html>