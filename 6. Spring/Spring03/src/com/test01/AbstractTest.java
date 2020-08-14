package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;
// 추상클래스로 객체를 만들 수 없는 class이다.
public abstract class AbstractTest {
	public abstract String dayInfo();
	
	public static AbstractTest getInstance() {
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK); // 요일 값을 리턴해주는애
		switch(day) {
		case 1 : return new Sunday();
		case 2 : return new Monday();
		case 3 : return new TuesDay();
		case 4 : return new Wednesday();
		case 5 : return new Thurday();
		case 6 : return new Friday();
		case 7 : return new Saturday();
		}
		return null;
	}
}
