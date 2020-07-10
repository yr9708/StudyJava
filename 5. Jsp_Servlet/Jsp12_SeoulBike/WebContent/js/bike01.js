$(function(){
	getBike();
});

function getBike(){
	$.getJSON("json/bike.json",function(data){
		$.each(data, function(key, val){ /* 반복함수, 
										만약 data가 [6,30] 배열형태면 function(index, val) 0 : 6, 1 : 30 이런식으로 리턴
										map { '하나' : '강동원', '둘' : '서강준' } 맵 형태면 하나 : 강동원 , 둘 : 서강준 이런식으로 리턴 */
			if(key == "DESCRIPTION"){
				$("table").attr("border",1);
				$("thead").append(
					"<tr>"+
						"<th>"+val.ADDR_GU+"</th>"+ // val = jsonObject
						"<th>"+val.CONTENT_ID+"</th>"+
						"<th>"+val.CONTENT_NM+"</th>"+
						"<th>"+val.NEW_ADDR+"</th>"+
						"<th>"+val.CRADLE_COUNT+"</th>"+
						"<th>"+val.LONGITUDE+"</th>"+
						"<th>"+val.LATITUDE+"</th>"+
					"</tr>"
				);
			}else {
				var list = val; 
				for(var i=0; i<list.length; i++){
					var str = list[i];
					$("tbody").append(
							"<tr>"+
								"<td>"+str.addr_gu+"</td>"+
								"<td>"+str.content_id+"</td>"+
								"<td>"+str.content_nm+"</td>"+
								"<td>"+str.new_addr+"</td>"+
								"<td>"+str.cradle_count+"</td>"+
								"<td>"+str.longitude+"</td>"+
								"<td>"+str.latitude+
								"<input type='hidden' name='bike' value='"+
									str.addr_gu+"/"+
									str.content_id+"/"+
									str.content_nm+"/"+
									str.new_addr+"/"+
									str.cradle_count+"/"+
									str.longitude+"/"+
									str.latitude+"'/>"+
								"</td>"+
							"</tr>"	
					);
				}
			}
		});
	});
}