package beakjoon;

import java.util.Scanner;

public class beakjoon2839 {

	public static void main(String[] args) {
		/*
		 * 상근이는 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야한다.
		 * 설탕은 봉지에 담겨져 있다.
		 * 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
		 * 
		 * 더 적은 갯수의 봉지를 들고가려고 한다.
		 * ex) 18킬로그램 설탕을 배달할 때 3키로 6봉지 or 5키로 3봉지+3킬로 1봉지 중 후자로 배달.
		 * 
		 * 설탕을 정확하게 N킬로그램 배달해야 할때 봉지 몇개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 킬로그램 배달할까요?");
		int n = sc.nextInt();
		sc.close();
		delivery(n);
	}
	
	public static void delivery(int n) {


		
//		정답 코드		
		int x =0;
		
		while(true) {
			if(n%5==0) { 
				System.out.println(n/5+x);
				break;
			}else if(n<=0){
				System.out.println(-1);
				break;
			}
			n-=3;
			x++;
		}
		
		/* 첫번째 코드 */
//		int cnt=3;
//		int a=Integer.MAX_VALUE;
//		int b=Integer.MAX_VALUE;
//		int z=Integer.MAX_VALUE;
//		int y=Integer.MAX_VALUE;
//		
//		// 완전탐색
//		// 3 * j + 5 * k >n
//		int plag = 0;
//
//		for (int j = 1; j<100; j++) {
//			for (int k = 1;  k<100; k++) {
//				if (3 * j + 5 * k == n) {
//					a = j + k; 
//					cnt=0;
//					plag=1;
//					break;
//				} else if (3 * k == n || 5 * k == n) {
//					if(3*k==n) {
//						z=k;
//					}else if(5*k==n) {
//						y=k;
//					}
//					
//					if(z>y) {
//						b=y;
//						cnt=1;
//					}else if(z<y){
//						b=z;
//						cnt=1;
//					}
//					plag=1;
//					break;
//				}
//			}
//			if(plag==1) break;
//		}
//		
//		if(a>b) {
//			cnt=1;
//		}else if(a<b) {
//			cnt=0;
//		}
//
//			switch(cnt){
//			case 0 :System.out.println(a); break;
//			case 1: System.out.println(b); break;
//			default : System.out.println(-1); break;
//			};

	

	}
 
}
