/*document.ready가 window.onload보다 먼저 실행된대여*/

$(function(){
   parseBike();
});


function parseBike(){
   $.getJSON("json/bike.json", function(data){
      $.ajax({
         url : "bike.do",
         method : "POST",
         data : {"obj":JSON.stringify(data),"command":"second_db"}, // servlet으로 보낼때는 data 지정, 받을때는 dataType 지정
         success : function(msg) {
            if(msg > 0) {
               alert(msg);
               $.each(data, function(key, val){
                  if (key == "DESCRIPTION") {
                     $("table").attr("border",1);
                     var $tr = $("<tr>"); // createElement
                     for(var i in val) {
                        $tr.append($("<th>").html(val[i]));
                        // for(var i in val)의 성질
                        // i 찍으면 key가 나오고
                        // val[i]를 찍으면 value가 나온다
                  
                     }
                     $("thead").append($tr);
                  } else {
                     for (var i = 0; i < val.length; i++) {
                        var $tr = $("<tr>");
                        for(var j in val[i]) { // DATA 는 현재 배열형태로 저장되어있음. i 는 0번지 j는 value임 그러니까 0번지의 0번째면 서울특별시 강남구 압구정로 134 이 됨 . 차례대로 나감
                           $tr.append($("<td>").html(val[i][j]));
                        }
                        $("tbody").append($tr);
                     }
                     
                  }
               });
            } else {
               alert("db 저장 실패...");
            }
         },
         error : function(){
            alert("통신 실패");
         }
      });
   });
}