<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	어서오시게 낯선이여
	여기는 I N D E X 라네
</h1>
<ul>
	<li>1. <a href="home.go">HOME</a></li>
	<li>2. <a href="command.go?name=강여림&grade=2&className=그냥딱대">getCommand</a></li>
	<li>3. 
		<form action="command.go" method="post">
			<table border="1">
				<tr>
					<th>NAME</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>GRADE</th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>CLASSNAME</th>
					<td><input type="text" name="schoolName"></td>
				</tr>
				<tr>
					<td colspan="2" > 
						<input type="submit" value="postCommand" style="float:right;">
					</td>
				</tr>
			</table>
		</form>
	
	
	</li>
</ul>
</body>
</html>