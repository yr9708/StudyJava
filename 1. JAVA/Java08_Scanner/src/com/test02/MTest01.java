package com.test02;

import java.util.Scanner;

public class MTest01 {
	public static void main(String[] args) {
	//	test01();
	//	test02();
		test03();
	}
	public static void test01() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력해 주세요");
		int a = sc.nextInt();
		System.out.println("두번째 숫자를 입력해주세요");
		int b = sc.nextInt();
		int sum = a+b;
		System.out.println("두 숫자의 합 : "+sum);
	}
	
	public static void test02() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력해주세요");
		String s = sc.nextLine();
		System.out.println("입력하신 문자 : "+s);
		
	}
	
	public static void test03() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력해주세요");
		String s = sc.next();
		System.out.println("입력하신 문자 : "+s);
		String s2 = sc.nextLine(); // 
		System.out.println("그리고 : "+s2);
		String s3 = sc.next();
		System.out.println("다음 :"+s3);
	}
}
