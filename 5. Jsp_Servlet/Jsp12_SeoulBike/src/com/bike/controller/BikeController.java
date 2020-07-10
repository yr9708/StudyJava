package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		BikeDao dao = new BikeDao();
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
		}else if(command.equals("first_db")) {
			if(dao.delete()) {
				System.out.println("삭제 성공");
			}
			
			String[] bikeList = request.getParameterValues("bike");
			List<BikeDto> list = new ArrayList<BikeDto>();
			
			
			for(int i=0; i<bikeList.length; i++) {
				String[] tmp = bikeList[i].split("/");
				BikeDto dto = new BikeDto(tmp[0],
								Integer.parseInt(tmp[1]),
								tmp[2],
								tmp[3],
								Integer.parseInt(tmp[4]),
								Double.parseDouble(tmp[5]),
								Double.parseDouble(tmp[6]));
				
				list.add(dto);
			}
			
			int res = dao.insertDb(list);
			if(res > 0) {
				System.out.println("insert성공");
			}else {
				System.out.println("insert실패");
			}
			
			response.sendRedirect("bike01.jsp");
			
		} else if(command.equals("second")){
			response.sendRedirect("bike02.jsp");
		}else if(command.equals("second_db")) {
			
			String objString = request.getParameter("obj");
		//	System.out.println(objString);
			
			JsonElement element = JsonParser.parseString(objString);	
		//	JsonObject jsonobj = (JsonObject) element;
			
			//System.out.println(element.getAsJsonObject().get("DESCRIPTION"));
			// Object로 바꿔서 description 을 찾았엉
			List<BikeDto> list = new ArrayList<BikeDto>();

			
			for(int i = 0; i<element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i++) {
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				// element 와 object의 차이점
				/*
				 JsonObject : name,value 한쌍이다! {'String' , 'jsonelement'}
				 JsonElement : Json요소임 -> JsonObject, JsonArray, JsonPrimitive(string,number,true,false), null
				 --> value !!!!! 어떤 type이 올 지 모르기 때문에!
				 
				 object 안에는 element와 array가 들어가 있다.
				 
				 element를 JsonObject 형태로 바꿔주고 memberName인 "DATA"를 찾아(DATA는 배열형태인 문자열로 되어있음) JsonArray로 바꿔준 array사이즈를 찾은것. 
				 element를 JsonOjbect 형태롤 바꿔주고 memberName인 "DATA"를 찾아 JsonArray로 바꾸고 그 배열의 i번째를 다시 JsonObject형태로 바꿔준것,, 1163번 바꾸겠군
				
				 */

				String addr_gu = tmp.get("addr_gu").getAsString();
				
				int content_id = tmp.get("content_id").getAsInt();
				
				JsonElement content_nm_je = tmp.get("content_nm");
				String content_nm = content_nm_je.getAsString();
				
				JsonElement new_addr_je = tmp.get("new_addr");
				String new_addr = new_addr_je.getAsString();
				
				int cradle_count = tmp.get("cradle_count").getAsInt();
				double longitude = tmp.get("longitude").getAsDouble();
				double latitude = tmp.get("latitude").getAsDouble();
				
				BikeDto dto = new BikeDto(addr_gu, content_id, content_nm, new_addr, cradle_count, longitude, latitude);
				list.add(dto);
			}
			
			if(dao.delete()) {
				System.out.println("삭제성공");
			}
			int res = dao.insertDb(list);
			if(res > 0) {
				System.out.println("저장 성공");
			}else {
				System.out.println("저장 실패");
			}
		
			
			response.getWriter().append(res+"");
		}
	}

}
