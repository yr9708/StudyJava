package com.test01;

public class Type04 {

	// 문자형
	// 문자열
	// 논리형
	public static void main(String[] args) {
		char c1 = 'a'; 
		System.out.println(c1);
		int c2 = c1;
		System.out.println(c2);
		
		String s1 = "aa";
		System.out.println(s1);
		String s2 = "bb";
		String sum2 = s1+s2;
		System.out.println(sum2);
		
		char lastName = '\uac15';
		System.out.println(lastName);
		
		System.out.println("----------------------------");
		
		boolean bl01 = true;
		boolean bl02 = false;
		
		System.out.println(bl01);
		System.out.println(bl02);
	}

}
