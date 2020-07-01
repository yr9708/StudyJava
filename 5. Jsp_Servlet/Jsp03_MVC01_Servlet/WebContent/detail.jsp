<%@page import="com.mvc.model.dto.MVCBoardDto"%>
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
	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto");
%>
<body>
   <div id="detailform">
      <h1>글 보기📄</h1>
      <table border="1">
         <tr>
            <th>작성자</th>
            <td><input type="text" readonly="readonly" value="<%=dto.getWriter() %>" /></td>
         </tr>
         <tr>
            <th>제  목</th>
            <td><input type="text" readonly="readonly" value="<%=dto.getTitle() %>" /></td>
         </tr>
         <tr>
            <th>내  용</th>
            <td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
         </tr>
         <tr>
            <td colspan="2" align="right">
            <input type="button" value="수정" onclick="location.href='controller.do?command=updateform&seq=<%=dto.getSeq() %>'" />
            <input type="button" value="삭제" onclick="location.href='controller.do?command=delete&seq=<%=dto.getSeq() %>'" />
            <input type="button" value="목록" onclick="location.href='controller.do?command=list'"/>
            </td>
         </tr>
      </table>
   </div>
</body>
</html>