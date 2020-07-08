
function getParameterValues(){
	var name = "name="+document.getElementById("name").value;
	var kor = "kor="+document.getElementById("kor").value;
	var eng = "eng="+document.getElementById("eng").value;
	var math = "math="+document.getElementById("math").value;
	
	var queryString = "?"+name+"&"+kor+"&"+eng+"&"+math;
	
	return queryString;
}

function load(){
	var url = "score.do"+getParameterValues();
//	alert(url);
	// var 가 생략이 되어서 변수가 호이스팅 된다. 전역변수 제일 위에 모여버린다.
	httpRequest = new XMLHttpRequest();				// XHR : 서버와 통신을 도와주는 객체
	httpRequest.onreadystatechange = callback;		// state가 변경될때마다 처리할 함수 (callback)
	httpRequest.open("GET",url,true);				// true : 비동기 , false : 동기
	httpRequest.send();								// .send() : get방식 , .send(String) : (값을보내면)post 방식
}

function callback(){
	alert("readyState : "+httpRequest.readyState);
	if(httpRequest.readyState == 4){
		alert("status : "+httpRequest.status);
		
		if(httpRequest.status == 200){
			var obj = JSON.parse(httpRequest.responseText);
			document.getElementById("result").innerHTML = 
				decodeURIComponent(obj.name) + " 의 총점은 "+
				obj.sum + "이고, 평균은 "+obj.avg+" 입니다.";
		}else{
			alert("데이터를 계산 할 수 없습니다.");
		}
	}
}
//callback은 함수명
// httpRequest.onreadystatechange = callback; 는 밑에 적어둔 1번부터 올라감 (0은 실행 안된 상태)
// 1씩 올라갈때마다 callback함수가 실행됨(아래에있는)
// 4번이 되는순간 서버에 요청을 끝냄 그때 우리가 원하는 걸 실행해줌
// 그 전에 에러메세지 httpRequest.status 이녀석이 띄워줌
// 200이면 통신 잘됨
// 나머지는 오류 404 500 400 403 등등
// 400 : bad request (get인데 post로 받거나 post인데 get으로 받거나)
// 401 : unauthorized (인증이 잘못된 경우)
// 403 : forbidden
// 404 : not found
// 500 : internal server error
// 이런 에러와 정상통신들이 status에 담기게됨


//콜백함수 : 무전기 시스템
// 내가 콜(요청)하면 백(응답) 해줄거야.
// callback에 괄호를 붙여주면 그냥 바로바로 실행이됨
// 근데 우리는 바뀔때마다 함수를 호출하는거라서 괄호를 안붙임



/*
	XMLHttpRequest : javascript object -> http라는 프로토콜을 통해서 데이터 송수신 지원 XHR
	<onreadystatechange>
	- readyState
	0 : uninitialized - 실행(load)되지 않음
	1 : loading - 로드 중
	2 : loaded - 로드 됨
	3 : interactive - 통신 됨
	4 : complete - 통신 완료
	
 	- status
	200 : 성공
	400 : bed request 
	401  : unauthorized 인증네 대해한 권한
	403 : forbidden
	404 : not found
	500 : internal server error
*/