package com.test01;

public class Mtest01 {
	
	public static void prn01() {
		while(true) {
			System.out.println("Hello, World!");
		}
	}
	
	public static void prn02() {
		int i =0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
		System.out.println("while이 종료된 후의 i = "+i);
	}
	
	
	public static void prn03() {
		int i = 1;
		do { 										// 거짓이라도 한번 무조건 실행 후 검증
			System.out.println(i);
			i++;
		}while(i==10);
			
			System.out.println("do while 이 종료된 후 i = "+i);
	}
	
	public static void prn04() {
		int i = 1;
		while(true) {
			System.out.println(i);
			if(i==10) {
				break;
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		// prn01();
	    // prn02();
		//prn03();
		prn04();
		
		
	}
}
