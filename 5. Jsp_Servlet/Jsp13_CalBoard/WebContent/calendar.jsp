<%@page import="com.cal.util.Utils"%>
<%@page import="java.util.Calendar"%>
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
	#calendar{
		border-collapse : collapse;
		border : 1px solid gray;	
	}
	#calendar a{
		text-decoration:none;
	}
	#calendar th{
		width: 80px;
		border: 1px solid gray;
	}
	#calendar td{
		width : 80px;
		height: 80px;
		border : 1px solid gray;
		text-align : left;
		vertical-align : top;
		position: relative;
	}
</style>
</head>
<body>
<%
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH) +1;
	
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");

	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	}
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	
	if(month > 12){
		year++;
		month = 1;
	}
	if(month < 1){
		year--;
		month = 12;
	}
	
	// 현재 년도 , 현재월, 1일 셋팅
	cal.set(year,month-1,1);
	// 1일의 요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	// 마지막 일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
/* 	
	final int leapYear= 366;
	final int nomalYear = 365;
	
	boolean isLeapYear = false;
	if((year%4==0) &&(year%100!=0)||(year%400==0)){
		isLeapYear = true;
	}
	
	int leapYearDay [] = new int [] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int nomalYearDay [] = new int [] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	int sumOfyear= 0;
	int sumOfDay= 0;
	int day = 0;
	for(int i=1; i<year; i++){
		if((i%4==0) &&(i%100!=0)||(i%400==0)){
			sumOfyear += leapYear;
		}else{
			sumOfyear += nomalYear;
		}
	}

	for(int i=0; i<month-1; i++){
		if(year!=1){
			if(isLeapYear==true){
				day = leapYearDay[i];
				sumOfDay += day;
			}else{
				day = nomalYearDay[i];
				sumOfDay += day;
			}
		}else{
			sumOfDay = 0;
		}
	}
	
	int checkWeek = (sumOfyear + sumOfDay +1) %7; */
	
	// 달력!
%>
	<table id="calendar">
		<caption>
			<a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◀◀</a>
			<a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◁</a>
			
			<span class="y"><%=year %></span> 년
			<span class="m"><%=month %></span> 월
			
			<a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▷</a>
			<a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▶▶</a>
		</caption>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
		
		<tr>
	<%
		//공백
		for(int i=0; i<dayOfWeek-1; i++){
			out.println("<td>&nbsp;</td>");
		}
		
		for(int i=1; i<=lastDay; i++){
	%>
		<td>
			<a href="cal.do?command=list&year=<%=year%>&month=<%=month%>&date=<%=i%>" style="color:<%=Utils.fontColor(i,dayOfWeek) %>"><%=i %></a>
			<a href="insertcalboard.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%>">
				<img alt="일정추가" src="img/pen.png" style="width:10px;height:10px">
			</a>
		</td>
		
	<%
			if((dayOfWeek-1 + i)%7 ==0){
				out.print("</tr><tr>");
			}
		}
	
		// 뒤쪽 공백
		for(int i =0; i< 7-(dayOfWeek-1 + lastDay)%7; i++){
			out.print("<td>&nbsp;</td>");
		}
	%>
		</tr>
		
		
<%-- 		<tr>
	<% 	
		for(int i=0; i<checkWeek; i++){
	%>
		<td>  </td>
	<%
		}
	
		if(isLeapYear==true){
			for(int i=1; i<leapYearDay[month-1]; i++){
	%>
		<td><%=i %></td>
	<%
				checkWeek++;
			if(checkWeek%7==0){
	%>
		</tr>
		<tr>
	<%
				}
			}
		}
	%>
		</tr> --%>
	</table>

</body>
</html>