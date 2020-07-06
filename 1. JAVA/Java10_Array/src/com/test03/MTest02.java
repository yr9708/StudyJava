package com.test03;

public class MTest02 {
	
	/*
	 *   1   2 	3 	 4	  5 
	 *   6   7 	8 	 9	10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * 
	 * 
	 * 2. for 문과 if 문을 사용하여 위와 같은 이차원 배열을 생성하자
	 * 3. 해당 배열을 출력하자
	 * 
	 * 
	 * 
	 *   1   2 	3 	 4	  5 
	 *  10  9 	8 	 7	  6
	 * 11 12 13 14 15
	 * 20 19 18 17 16
	 * 21 22 23 24 25
	 * 
	 * 
	 * i랑 j가 같아지면 
	 * i=0 j=4
	 * 
	 * 
	 * (0.0) (0.1) (0.2) (0.3) (0.4)
	 * (1.0) (1.1) (1.2) (1.3) (1.4)
	 * (2.0) (2.1) (2.2) (2.3) (2.4)
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		int cnt=0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				cnt++;
				arr[i][j]=cnt;
				System.out.printf("%3d",arr[i][j]);
				if(j==4) {
					System.out.println();
				}
			}
		}
		
		System.out.println("---------------");
		
		// reverse
		int[][] arr2=new int [5][5];
		int cnt2=1;
		
		for(int i =0; i<arr2.length; i++) {			
			if(i%2==0) {
				for(int j=0; j<arr2[i].length; j++) {
					arr2[i][j]=cnt2++;
				}
			}else {
					for(int j=arr2[i].length-1; j>=0; j--) {
						arr2[i][j]=cnt2++;
					}
				}
			}
		
		// 출력
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%3d",arr2[i][j]);
			}
			System.out.println();
		}


		
		
		
		
		}	
}
