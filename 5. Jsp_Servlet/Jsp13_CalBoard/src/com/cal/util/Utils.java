package com.cal.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;



public class Utils {
	
	private String toDates;
	
	public String getToDates() {
		return toDates;
	}
	
	public void setToDates(String mdate) {
		// yyyy-MM-dd hh:mm:00
		// timestamp가 이런 형태를 받아서 바꿔주기때문
		// date는 밀리세컨즈, timestamp는 나노세컨즈
		String m = mdate.substring(0, 4) + "-" 
				+ mdate.substring(4, 6) + "-"
				+ mdate.substring(6, 8) + " "
				+ mdate.substring(8, 10) + ":"
				+ mdate.substring(10) + ":00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		/*
		 SimpleDateFormat 은 text를 date로, date를 text로 파싱 시켜주는 클레스이다. 
		 It allows for formatting (date → text), parsing (text → date), and normalization.
		 */
		Timestamp tm = Timestamp.valueOf(m);
		/*
		 JDBC API
		 Converts a String object in JDBC timestamp escape format to a Timestamp value.
		 */
		toDates = sdf.format(tm);
		
	}
	
	// 한자리수 숫자에 0 붙여주는 메소드
	public static String isTwo(String msg) {
		/*
		 * if(Integer.parseInt(msg) < 10) 
		 * { return 0+msg; 
		 * } else { 
		 * return msg; }
		 */
		return (msg.length()<2)?"0"+msg:msg;
	}
	
	// 달력의 토요일, 일요일, 평일 색상을 설정
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		if((dayOfWeek-1 +date)%7 == 0) {
			color="blue";
		}else if((dayOfWeek-1 +date)%7 == 1){
			color="red";
		}else {
			color="black";
		}
		return color;
	}
}
