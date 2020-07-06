package com.test01;

public class Mtest02 {

	public static void main(String[] args) {
		/*
		 *  1. 입력하는 수가 5의 배수이면 "5의 배수입니다" 를 출력하는 메소드를 만들자.
		   test01(10);
		 *  2. 입력받은 수가 2의 배수이면서 3의 배수이면 "2와 3의 공배수 입니다."
		 * 		아니라면, "2와 3의 공배수가 아닙니다." 라고 출력하자.
		 * test02(9);
		 *  3. 입력받은 문자가 소문자라면 "소문자 입니다.", 대문자라면 "대문자 입니다". 을 출력하자.
		 * test03('A');
		 */
		 test01(10);
		 test02(9);
		 test03('1');
	}

	public static void test01(int i) {
		if( i % 5 == 0) {
			System.out.println("5의 배수입니다.");
		}
	}
	
	public static void test02(int i) {
		if( i % 3 == 0 && i % 2==0) {
			System.out.println("2와 3의 공배수 입니다.");
		}else {
			System.out.println("2와3의 공배수가 아닙니다.");
		}
		
	}
	
	public static void test03(char c) { // hint : java.lang.Character
		if (Character.isUpperCase(c)) {
			System.out.println("대문자 입니다.");
		}else if(Character.isLowerCase(c)){
			System.out.println("소문자 입니다.");
		}else {
			System.out.println("알파벳이 아닙니다.");
		}
	}
}
