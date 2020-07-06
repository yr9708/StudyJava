package com.random;

public class RandomCube {
		public static void main(String[] args) {
			prn();
		}
		/*
		 * 1. 1 ~ 9 사이의 5 * 5 큐브를 출력하자
		 * 2. X 형태의 총 합과,
		 * 	X 형태의 값으 평균을 구하자.
		 * 
		 */
		public static void prn() {
			
			int sum=0;
			int count =0;
			
			
			for(int i =0; i<5; i++) {
				for(int j=0; j<5; j++) {
				
					int cnt = (int)(Math.random()*9)+1;
					System.out.print(cnt+" ");
					
					if(i==j || i+j==4) {
						sum+=cnt;
						count++;
					}
				} 
				System.out.println();
			}
				System.out.println();
				System.out.printf("X의 합은 %d 입니다.\n",sum);
				System.out.printf("X의 평균은 %.2f 입니다.",(double)(sum)/count);
		}
		
		
}
