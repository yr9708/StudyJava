package com.test02;

public class Gugu {
	public static void main(String[] args) {
	//	gugudan();
		gugudan2();
	}
	
	public static void gugudan() {
		// 2 * 1 = 2
		// ,,,
		// 9 * 9 = 81
		// for 문을 사용해서 구구단 출력하자
	
		for (int i = 2; i<10; i++) {
			for(int j = 1; j<10; j++) {
				int result = i * j;
				System.out.printf("%d * %d = %d\n",i, j, result);
			}
			System.out.println();
		}
		
	}
	
	public static void gugudan2() {
		// while 사용해서 출력
		
//		int i =1;
//		int j =1;
//	
//	
//		while(true) {
//			i++;
//			if(i>9) 	break;
//			
//			while(true) {
//				int result = i * j;
//				System.out.printf("%d * %d = %d\n",i, j, result);
//				j++;
//				if(j>9) {
//					j=1;
//					break;
//				}
//			}
//		}
		
		// 강사님 코드
		
		int i =2;
		
		while(i<10) {
			System.out.println("<<"+i+"단>>");
			int j =1;
			
			while(j<10) {
				System.out.printf("%d * %d = %d\n",i,j,(i*j));
				j++;
			}
			i++;
			System.out.println();
		}

	}
}
