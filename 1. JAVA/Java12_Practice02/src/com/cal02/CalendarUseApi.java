package com.cal02;

import java.util.Calendar;

public class CalendarUseApi {
	public static void prn(int year, int month) {
		//윗부분
		System.out.printf("\t\t\t %d년 %d월 \n",year,month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		
		Calendar cal = Calendar.getInstance();		// 싱글톤
		cal.set(year,month-1,1);							// 4월이다 라고 하면 3이라는 숫자에 4월이 저장되어 있음
		
		int start = cal.get(Calendar.DAY_OF_WEEK); 
		// 무슨 요일부터 1일이 시작이 되는가. 일요일 : 1
		// 값 중에 현재 세팅되어 있는 일자의 해당 요일을 가지고 와준다.
		
		
		// 시작되는 요일 빈칸 만들기, 일요일이 1일이니까 
		for(int i =1; i<start; i++) {
			System.out.printf("\t");
		}
		
		
		// 출력
		for(int i=1; i<=cal.getActualMaximum(Calendar.DATE);i++) {
			System.out.printf("%d\t",i);
			if(start%7==0) {
				System.out.println();
			}
			start++;
		}
		
		
		
		
		
		
		
	}

}
