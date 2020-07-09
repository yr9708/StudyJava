<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:catch var="err">
	<c:set var="weatherURL"
		value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${code}" />
	<c:import var="weather" url="${weatherURL}" /> <%-- 링크에 있는 값(XML파일)을 제대로 가지고 오겠다 --%>
	<x:parse var="wrss" xml="${weather}" /> <%-- 응답받은 데이터(문자열인 XML파일)을 parse하여 xml파일로 쓰겠다 --%>
	<%-- 기상청에서 제공하는 데이터를 (rss에서 긁어오는 것) JSON으로 입력 --%>
{"pubDate":"<x:out select="$wrss/rss/channel/pubDate" />", <%-- x:out html모양으로 만든 문자열로 출력  c:, x: 모두 java(server)에서 컴파일 해줌--%>
"temp":"<x:out 
		select="$wrss/rss/channel/item/description/body/data/temp" />",
"reh":"<x:out select="$wrss/rss/channel/item/description/body/data/reh" />",
"pop":"<x:out select="$wrss/rss/channel/item/description/body/data/pop" />",
"x":"<x:out select="$wrss/rss/channel/item/description/header/x" />",
"y":"<x:out select="$wrss/rss/channel/item/description/header/y" />",
"wfKor":"<x:out
		select="$wrss/rss/channel/item/description/body/data/wfKor" />"

		}
</c:catch>
<c:if test="${err!=null}">
	${err}
</c:if> 
