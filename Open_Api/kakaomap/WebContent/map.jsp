<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
   	response.setContentType("text/html; charset=UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
<style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background:#EED4DB;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>
</head>
<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=68bbb576a7ffd0b92dd5af16e42288cb"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.4991053,127.0329041),
			level: 3
		};
		// 지도 생성
		var map = new kakao.maps.Map(container, options);
		
		// 마커 표시될 위치
		var markerPosition = new kakao.maps.LatLng(37.4991053,127.0329041);
		
		// 지도에 마커 생성
		var marker = new kakao.maps.Marker({
			map:map,
			position:markerPosition
		});
		
		var content = '<div class="wrap">' + 
        '    <div class="info">' + 
        '        <div class="title">' + 
        '            KH정보교육원' + 
        '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
        '        </div>' + 
        '        <div class="body">' + 
        '            <div class="img">' +
        '                <img src="http://blogfiles.naver.net/20160425_56/skh556_1461566402812wwoux_JPEG/03_KH%C1%A4%BA%B8%B1%B3%C0%B0%BF%F8_%BF%F8%C7%FC%C4%C3%B7%AF.jpg" width="73" height="70">' +
        '           </div>' + 
        '            <div class="desc">' + 
        '                <div class="ellipsis">서울특별시 강남구 테헤란로 14길 6 남도빌딩 </div>' + 
        '                <div class="jibun ellipsis">T: 1544-9970 / F: 02-562-2378</div>' + 
        '                <div><a href="https://www.iei.or.kr/main/main.kh" target="_blank" class="link">홈페이지</a></div>' + 
        '            </div>' + 
        '        </div>' + 
        '    </div>' +    
        '</div>';
		
        // 마커 위에 커스텀오버레이를 표시
        // 마커를 중심으로 커스텀 오버레이를 표시하기 위해 CSS를 이용해 위치를 설정
        var overlay = new kakao.maps.CustomOverlay({
        	content : content,
        	map : map,
        	position : marker.getPosition()
        });
        
        // 마커를 클릭했을 때 커스텀 오버레이를 표시
        kakao.maps.event.addListener(marker, 'click', function(){
        	overlay.setMap(map);
        });
        
        // 커스텀 오버레이를 닫기 위해 호출되는 함수
        function closeOverlay(){
        	overlay.setMap(null);
        }
		
	</script>
</body>
</html>