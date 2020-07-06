package com.test03;

import java.util.Arrays;

public class Mtest01 {
	/*
	 * 1. 5칸 짜리 int 1차원 배열 생성하자.
	 * 2. 반복문을 사용하여 배열의 0번지부터 3번지까지 (4개)
	 * 	5~9 사이의 난수를 대입하자.
	 * 3. 배열의 0~3번지에 대입된 값을들을 모두 곱해서 4번에index에 저장하자
	 * 4. 배열을 출력하자.
	 * 5. 배열 안의 모든 값을 더해서 출력하자
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = new int[5];
		int mutiple =1;
		
		for(int i =0; i<4; i++) {
			int random = (int)(Math.random()*5)+5;		// +5 : 5부터 *5 5개(9-5)
			arr[i]=random;
			mutiple *= arr[i];
		}
		
		arr[4]=mutiple;
		
		System.out.println(Arrays.toString(arr));
		int sum=0;
		for(int i =0; i<arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println("배열 더한 모든값 : "+sum);
		
		
	}
}
