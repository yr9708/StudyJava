package com.test03;

public class MyCalc {
	
	// 접근제한자 메모리영역 리턴타입 메소드명(파라미터){} <-{}블록,바디라고 부른다.
	
	public static void sum(int i, int j) {
		int result = i + j;
		System.out.println(result);
	}
	
	public static int sub(int i, int j) {
		int res = i - j ;
		
		return res;
	}
	
	public static double mul(double d, int i) {
		double result = d * i ;
		
		return result;
	}
	
	public static void div(int i, int j) {
		int moc = i / j ; // 나눈 후의 몫
		int nmg = i % j ; // 나눈 후의 나머지
		
		System.out.printf("%d / %d의 몫 : %d\n",i, j, moc);
		System.out.printf("%d / %d의 나머지 : %d\n",i, j, nmg);
	}
	
}
