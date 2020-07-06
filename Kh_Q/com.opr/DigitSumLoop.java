package com.opr;

import java.util.Scanner;

public class DigitSumLoop {
	public static void main(String[] args) {
		// 반복문을 사용하여 자릿수 구하기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("4자리 숫자를 입력해주세요");
		int input= sc.nextInt();
		
		// 사칙연산을 이용하여 각 자리수를 구하자
//		int a=(input/1)%10;				// 1의자리
//		int b=(input/10)%10;			// 10의자리
//		int c=(input/100)%10;			//100의 자리
//		int d=(input/1000)%10;		//1000의 자리

		int sum=0;
		
//		for(int target=input; target>0; target/=10) {
//			System.out.println(target);
//			sum += target%10;
//		}
		
		int digit=0;
		
		for(int i=0; i<4; i++) {
			digit= (int)((sum/Math.pow(10, i))%10);
			sum+= digit;
		}
		
		
		System.out.println(sum);
		
	}
}
