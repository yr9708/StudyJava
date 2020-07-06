package com.test01;

public class MinMax {
	public static void main(String[] args) {
		/*
		 * 1. 어디서나 접근 가능하며,
		 * 		모든 기능을 수행한 후에는 정수 하나가 리턴되는 min이라는 이름의 메소드를 만들자.
		 * 		해당 메소드는 정수값 두개를 입력받아서 둘 중 더 작은 숫자를 리턴해주는 기능을 한다.
		 * 		-삼항 연산자를 사용하자.
		 * 
		 * 2. 위와 같은 방법으로, 둘 중 더 큰 숫자를 리턴해주는 기능을하는 max라는 메소드를 만들자.
		 * 		
		 * 3. main 메소드에서
		 * 		임의의 숫자 두개를 넣어서, min메소드와 max 메소드에서 리턴되는 값을 출력하자.
		 * 
		 * 
		 */	
		
		
		int a = (int)(Math.random()*100);
		int b = (int)(Math.random()*100);
		
		System.out.println(min(a,b));
		System.out.println(max(a,b));
	}
	public static int min(int a, int b) {
		int result = a < b ? a : b;
		return result;
	}
	
	public static int max(int a, int b) {
		int result = a < b? b : (a > b)? a : a;
		return result;
	}
	
}
