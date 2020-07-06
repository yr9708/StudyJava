package com.opr;

import java.util.Scanner;

public class DigitSum {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("4자리 숫자를 입력해주세요");
		int input= sc.nextInt();
		
		// 사칙연산을 이용하여 각 자리수를 구하자
//		int a = (input-(input%1000))/1000;
//		int b =	((input%1000)-((input%1000)/100))/100;
//		int c =	(input-((a*1000)+(b*100)))/10;
//		int d =	(input-((a*1000)+(b*100)))%10;
		
		int a=(input/1)%10;				// 1의자리
		int b=(input/10)%10;			// 10의자리
		int c=(input/100)%10;			//100의 자리
		int d=(input/1000)%10;		//1000의 자리
		
	
		int sum = a+b+c+d;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(sum);
	}
}
