$(function() {
	$("#weaView").click(
			function() {
				var url = "weatherOpen";
				var code = $("#address option:selected").val();
				$.ajax({
					type : "GET",
					url : url + "?code=" + code,
					dataType : "text",
					success : function(data) {
						
						var temp = $.trim(data);
						alert(temp);
						var obj = JSON.parse(temp);
						// JSON.stringify Json 객체를 json형태의 String로 바꿔준다(그냥 String 임.)
						
						$("#pubDate").val(obj.pubDate);
						$("#temp").val(obj.temp);
						$("#x").val(obj.x);
						$("#y").val(obj.y);
						$("#reh").val(obj.reh);
						$("#pop").val(obj.pop);
						$("#wfKor").val(obj.wfKor);

						var weather_condition = obj.wfKor;
						if (weather_condition == "맑음"){
							$("#weather_img").attr("src","/Jsp11_Weather/image/sun.png");
						}else if (weather_condition == "비"){
							$("#weather_img").attr("src","/Jsp11_Weather/image/rain.png");
						}else if (weather_condition == "눈"){
							$("#weather_img").attr("src","/Jsp11_Weather/image/snow.png");
						}else if (weather_condition == "흐림"){
							$("#weather_img").attr("src","/Jsp11_Weather/image/cloud.png");
						}else if (weather_condition == "구름 조금"){
							$("#weather_img").attr("src","/Jsp11_Weather/image/cloud_sun.png");
						}else{
							$("#weather_img").attr("src","/Jsp11_Weather/image/etc.png");
						}
					},
					error : function() {
						alert("정보를 불러오는데 실패하였습니다.");
					}
				});
			});
});
