package com.test04;

public class Star {
	
	//	*
	//	**
	//	***
	//	****
	//	*****
	public void prn01() {
		
		for(int i = 1; i<=5; i++) {
			for(int j =0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==========");
		
//		for(int i = 0; i<=5; i++) {				강사님 코드.
//			for(int j =0; j<i+1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("==========");
		
		
		
	}
	
	//	*****
	//	****
	//	***
	//	**
	//	*
	public void prn02() {
		
		for(int i = 1; i<=5; i++) {
			for(int j =6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	
		System.out.println("==========");
		
//		for(int i = 0; i<5; i++) {
//			for(int j =0; j<5-i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		
		
	} 
	//           *	
	//         **
	//	      ***
	//  	****
	//	  *****    
	public void prn03() {
//		for(int i = 1; i<=5; i++) {			내 코드
//			for(int j = 5; j>i; j--) {
//				System.out.print(" ");
//			}
//			for(int c =1; c<=i; c++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("==========");
//		
		
		for(int i = 0; i <5; i++) {
			// j는 공백갯수 4-0, 4-1, 4-2, 4-3, 4-4
			for(int j = 0; j<4-i; j++) {
				System.out.print(" ");
			}
			
			// k는 *의 갯수 0+1, 1+1, 2+1, 3+1, 4+1
			for(int k =0;k<i+1;k++) {
				System.out.print("*");
			}
			
			System.out.println();
			
		}
		
		System.out.println("==========");
		
		
	}
	//					i(줄) k(공백)	j(별)
	//	*****		0		0			5-0
	//	  ****		1		1			5-1
	//	    ***		2		2			5-2
	//	      **		3		3			5-3
	//         *		4		4			5-4
	public void prn04() {
		for(int i = 0; i <5; i++) {
			
			for(int k =0; k<i; k++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j<5-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==========");
		
		
		
//		for(int i = 0; i<5; i++) {
//			for(int j =0; j<5-i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//			for(int c = 0; c<=i; c++) {
//				System.out.print(" ");
//			}
//		}
//		System.out.println("==========");
	}
	
	
	//	      *
	//	    ***
	//	   *****
	//	 *******
	//	*********
	//	
	
	public void prn05() {
		
		// 강사님 코드
		for (int i=0; i<5; i++) {
			// 공백
			for(int j=4-i; j>0; j--) {
				System.out.print(" ");
			}
			// 별 갯수 0+1, 2+1, 4+1, 6+1 ,,,
			// (2*i)+1
			for(int k=0; k<2*i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		
		for(int i = 0; i <5; i++) {
			
			for(int j = 0; j<4-i; j++) {
				System.out.print(" ");
			}
			
			for(int k =0;k<(2*i)+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("===========");
	}

}
