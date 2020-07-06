package com.lotto;

import java.util.Arrays;

public class Lotto {
	public static void main(String[] args) {
		/*
 로또번호를 출력하는 코드를 작성하자(1~45 사이의 중복되지 않는 6개 숫자)
- 중복 방지 메서드와 정렬 메서드를 구현해서 출력하자
		 */
	
	//	System.out.println(Arrays.toString(make()));
		Lotto lotto = new Lotto();
		lotto.prn();
		
	}
	
	// 로또 배열 생성
	private  int[] make() {

		int[] arr= new int[6];
		
//		for (int i = 0; i < arr.length ; i++) {
//			int insert = (int) (Math.random() * 45) + 1;
//			arr[i] = insert;
//			if (isSame(arr, insert)) {
//				i--;
//			}
//		}
		int idx=0;
		while(idx<6) {
			int insert = (int)(Math.random()*45)+1;
			
			if(!isSame(arr,insert)) {
				arr[idx]=insert;
				idx++;
			}
		}
		
	// 처음 내꼬	
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 45) + 1;
//			for (int j = 0; j < i; j++) {
//				if (arr[i] == arr[j]) {
//					i--;	// 다시 상위 for문으로 가서 뽑아라
//					//	arr[i + 1] = (int) (Math.random() * 45) + 1;
//				}
//			}
//		}
//		
		
		return arr;
	}
	
	// 중복
	public boolean isSame(int[]arr, int insert) {
		
//		for(int i=0 ; i<arr.length-1; i++) {
//			
//				if(i>0 &&arr[i]==arr[i-1] )
//					return true;
//			
//
//		}
		boolean same = false;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==insert) {
				same=true;
				break;
			}
		}
		return same;
	}
	
	// 정렬 (작은수부터)
	private void sort(int[]arr) {
		int tmp=0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] < arr[j - 1]) {
					tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}
	
	//출력
	public void prn() {
		int[] arr=make();
		sort(arr);
		
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1) {
				System.out.print(arr[i]);
			}else {
			System.out.print(arr[i]+", ");
			}
		}
		System.out.println("]");
	}

}
