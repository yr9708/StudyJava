package com.test01;

public class Mtest01 {
	
	public static void prn02() {
	
		int i = 2;
		
		// fall through
		switch(i) {
		case 1 : 
		case 3 : System.out.println("홀수 입니다."); break;
		case 2 :
		case 4 :	System.out.println("짝수 입니다."); break;
		}
		
	
	}
	
	
	public static void main(String[] args) {
		prn01();
		prn02();

	}

	public static void prn01() {
		// if는 순차적으로 모든 코드를 읽어들인다.
		// switch 는 해당 case 로 jumping 하기 때문에
		// compiler가 작업하기 편하다.
		
		int i = 2; 
		switch(i) {
		case 1 : System.out.println("1 입니다.");
		break;
		case 2 : System.out.println("2 입니다.");
		break;
		case 3 : System.out.println("3 입니다.");
		break;
		case 4 : System.out.println("4 입니다.");
		break;
		default : System.out.println("다른 숫자 입니다."); // case에 대항되는 값이 없을 때, 제일 밑에다가 두어서 break 써주지 않아도 상관없음
		}
	}
}
