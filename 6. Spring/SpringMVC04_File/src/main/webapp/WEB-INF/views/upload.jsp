<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Page</h1>
	<!-- enctype : form data가 서버로 전송되는 데이터 형식 설정
		multipart/form-data : 파일이나 이미지를 보낼때 사용
	method가 post인 경우에만 사용가능 
		
	-->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		file<br/>
		<input type="file" name="mpfile"><br/>
		<p style="color:red; font-weight:bold;"><form:errors path="mpfile"/></p><br/>
		
		description<br/>
		<textarea rows="10" cols="40" name="desc"></textarea><br/>
		<input type="submit" value="send"/>
	</form:form>
	<!-- 
		spring form tag
		form:form, form:error, form:input, ...
		
		form:errors -> Errors, BindingResult를 사용할 때
		command객체의 특성 field 에서 발생하는 예외에 대한 메세지 출력 가능
	 -->
	 
	 <!-- 
	 	enctype 속성
	 	1. application/www-form-urlencoded : 문자들이 encoding 됨 (default)
	 	2. multipart/form-data : file upload - post만 가능
	 	3. text/plain : 문자들을 encoding 하지 않음
	  -->
</body>
</html>