package com.test02;

import java.util.Arrays;

public class MTest02 {
	public static void main(String[] args) {
		int[] original = {10, 20, 30 ,40};
		int[] copyOne = new int[original.length];
		
		for(int i =0; i<original.length; i++) {
			copyOne[i]=original[i];
		}
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copyOne));
		System.out.println(original==copyOne);
		
		copyOne[1]=22;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copyOne));
		
		System.out.println("------------------");
		
		int[] copyTwo=original.clone();		// 해당 배열을 똑같이 복사해주세요
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copyTwo));
		System.out.println(original==copyTwo);
		
		System.out.println("------------------");
		
//		System.arrayCopy(
//										원본 배열 객체,
//										원본 시작 위치,
//										복사 배열 객체,
//										복사 시작 위치,											
//										복사 갯수
//		);
		
		int[] systemArray = new int[10];	// 현재 0으로 꽉 채워져 있음
		Arrays.fill(systemArray, 100);		// systemArray에다가 숫자100으로 꽉 채워주세요 
		System.out.println(Arrays.toString(systemArray));
		// 10, 20, 30, 40
		System.arraycopy(original,0,systemArray,2,3);	// 배열을 복사할건데 original의 0번째 값을 systemArray의 2번째부터 3개에 복사해줘)
		System.out.println(Arrays.toString(systemArray));
		System.out.println("------------------");
		
		// 각각의 주소값이 모두 달라요.
		System.out.println(original);
		System.out.println(copyOne);
		System.out.println(copyTwo);
		System.out.println(systemArray);
	}
}
