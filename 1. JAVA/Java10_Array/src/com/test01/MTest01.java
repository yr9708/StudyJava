package com.test01;

import java.util.Arrays;

public class MTest01 {
	public static void main(String[] args) {
		// 방법 1
		int [] a  ;				// 선언	int a [] 대괄호를 뒤에 써도 되지만 java에서는 거의 앞에 사용
		a = new int[5];	// 정의
		a[0]=1;				// 초기화
		a[1]=2;
		a[2]=3;
		a[3]=4;
		a[4]=5;
		
		// 방법 2
		int[] b = new int[] {5,3,1,2,4};		// 선언, 정의, 초기화 한번에 쓸 수 있음.
		
		// 방법 3
		int[] c = {6,7,9,0,8};						// 선언, 초기화. ->선언하고 바로 초기화 시킬 수 있음.
		
		
		System.out.println(a[2]);
		System.out.println(b[3]+c[2]);
		
		System.out.println(c);
		
		prn(c);
		
		String[] s = new String [] {"have", "a", "nice", "day"};
		modi(s);
		System.out.println();
		System.out.println(Arrays.toString(b));
		
	}
	
		public static void prn(int[] arr) {
			// arr 의 0번지 부터 arr.length-1 번지까지
			// 반복적으로 출력
			
			for(int i = 0; i<arr.length; i++) {
				System.out.printf("%d ",arr[i]);
			}
		}
		
		public static void modi(String[] s) {
				// s 배열에서 nice를 good 으로 바꾸고, 전체 출력하자.
			
			for(int i=0; i<s.length; i++) {
				if(i==2) {
					s[i]="good";
				}
				System.out.printf("%s ",s[i]);
			}
			
		
		}
		
}
