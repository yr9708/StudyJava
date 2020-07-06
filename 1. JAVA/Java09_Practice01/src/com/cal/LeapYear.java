package com.cal;

import java.util.Scanner;

public class LeapYear {
	/*
	 * ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, 
	 * ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 
	 * ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.
	 */
	public static void main(String[] args) {
		// 임의의 연도를 입력했을 때 
		// 해당 연도가 윤년이면 "xxxx 년은 윤년이 맞습니다"
		// 윤년이 아니면 "xxxx 년은 윤년이 아닙니다."
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력해주세요");
		int year = sc.nextInt();
		
		if(isLeapYear(year)==true) {
			System.out.printf("%d년은 윤년이 맞습니다",year);
		}else {
			System.out.printf("%d년은 윤년이 아닙니다.",year);
		}
	sc.close();
	}
	
	public static boolean isLeapYear(int year) {
		
		if(year%4==0 && (year%100!=0 || year%400==0)) {
			return true;
		}else {
			return false;
		}
		
	}
}
