<%@page import="com.mvc.model.dto.MVCBoardDto"%>
<%@page import="com.mvc.model.biz.MVCBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #updateform{display: none;}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
   function updateFormView(){
      $("#detailform").hide();
      $("#updateform").show();
   }
   function detailFormView(){
      $("#detailform").show();
      $("#updateform").hide();
   }
</script>
</head>
<body>
<%
   MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto");
%>

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
            <input type="button" value="수정" onclick="updateFormView();" />
            <input type="button" value="삭제" onclick="location.href='boardcontroller.jsp?command=delete&seq=<%=dto.getSeq() %>'" />
            <input type="button" value="목록" onclick="location.href='boardcontroller.jsp?command=list'" />
            </td>
         </tr>
      </table>
   </div>
   
   <div id="updateform">
      <h1>글 수정📝</h1>
      <form action="boardcontroller.jsp" method="post"> <!-- form태그에는 aciotn에 물음표 붙여서 보내지 않는다. -->
      	<input type="hidden" name="command" value="update">
      	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	      <table border="1">
	         <tr>
	            <th>작성자</th>
	            <td><input type="text" readonly="readonly" value="<%=dto.getWriter() %>" /></td>
	         </tr>
	         <tr>
	            <th>제  목</th>
	            <td><input type="text" name="title" value="<%=dto.getTitle()%>"/></td>
	         </tr>
	         <tr>
	            <th>내  용</th>
	            <td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
	         </tr>
	         <tr>
	            <td colspan="2" align="right">
	               <input type="submit" value="수정" />
	               <input type="button" value="취소" onclick="detailFormView();" />
	               <input type="button" value="목록" onclick="location.href='boardcontroller.jsp?command=list'" />
	      </table>
      </form>
   </div>
<%--    
   <hr>
   <h1>글 상세보기</h1>
   <table border="1" style="width: 100%;">
      <tr>
         <th>이름</th>
         <td><%=dto.getWriter() %></td>
      </tr>
      <tr>
         <th>제목</th>
         <td><%=dto.getTitle() %></td>
      </tr>
      <tr>
         <th>내용</th>
         <td><textarea><%=dto.getContent() %></textarea></td>
      </tr>
      <tr>
         <td colspan="2" align="right">
         <input type="button" value="수정" 
            onclick="location.href='boardcontroller.jsp?command=update&seq=<%=dto.getSeq() %>'" />
         <input type="button" value="삭제" 
            onclick="location.href='boardcontroller.jsp?command=delete&seq=<%=dto.getSeq() %>'" />
         <input type="button" value="목록" onclick="location.href='boardcontroller.jsp?command=list'"/>
         </td>
      </tr>
   </table> --%>
</body>
</html>