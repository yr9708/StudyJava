package com.test03;

public class MTest03 {
	/*
	 * 1 4 7
	 * 2 5 8
	 * 3 6 9 
	 * 모양의 배열을 생성하고 출력하자
	 * 
	 * (0.0) (0.1) (0.2)
	 * (1.0) (1.1) (1.2)
	 * (2.0) (2.1) (2.2)
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int [][] arr = new int[3][3];
		int value=1;
		for(int i =0; i<3; i++) {
			for(int j=0; j<3; j++) {
					arr[i][j]=value;
					value=value+3;
					System.out.printf("%3d",arr[i][j]);
			}
			value=value-8;
			System.out.println();
		}
		
		System.out.println("------------");
		
		
		int[][]arr2 = new int [3][3];	
		
		int cnt=1;
		for(int i =0; i<arr2.length;i++) {
			for(int j=0; j<arr2[i].length; j++) {
				arr2[j][i]=cnt++;
				
			}
		}
		
		// 출력
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("%3d",arr2[i][j]);
			}
				System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
