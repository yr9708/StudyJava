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
	$("#loinchk").hide();
});

function loginPrc(){
	var memberid = $("#memberid").val().trim();
	var memberpw = $("#memberpw").val().trim();
	var loginVal = {
			"memberid" : memberid,
			"memberpw" : memberpw
	}
	
	if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
		alert("ID,PW 공백 없이 입력해주세요");
	}else{
		$.ajax({
			type : "post",
			url : "ajaxlogin.do",
			data : JSON.stringify(loginVal),
			contentType : "application/json",
			dataType : "json", 
			beforeSend : function(xmlHttpRequest){
				xmlHttpRequest.setRequestHeader("AJAX","true");
			},
			success : function(msg){
				if(msg.check==true){
					location.href="list.do";
				}else{
					$("#loginchk").show();
					$("#loginchk").html("ID 또는 PW가 잘못되었습니다.");
				}
			},
			error : function(){
				alert("통신 실패!");
			}
		});
	}
}
</script>
</head>
<body>
<table border="1" style="border-collapse:collapse;">
	<tr>
		<th>ID</th>
		<td><input type="text" id="memberid"></td>
	</tr>
	<tr>
		<th>PW</th>
		<td><input type="text" id="memberpw"></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="login" onclick="loginPrc();">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" id="loginchk" style="color:red;"></td>
	</tr>
</table>
</body>
</html>