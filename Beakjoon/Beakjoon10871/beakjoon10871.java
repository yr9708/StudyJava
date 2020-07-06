package beakjoon;

import java.util.Scanner;

public class beakjoon10871 {

	public static void main(String[] args) {

//		int a=0;
//		int b=0;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 몇개로 수열을 만들까요? 1~10,000사이의 숫자값 입력");
//		int checkA= sc.nextInt();
//	
//		if(checkA<0 || checkA>10000) {
//			System.out.println("잘못된 입력값 입니다.");
//		}else {
//			a = checkA;
//		}
//		
//		System.out.println("X값을 입력해주세요");
//		b = sc.nextInt();
//		sc.close();
//		
//		test(a,b);

		Scanner scan = new Scanner(System.in);
		System.out.println("몇개를 만들건지? ");
		int num = scan.nextInt();
		System.out.println("비교할 값은? ");
		int b = scan.nextInt();
		prn(num,b);
		
		scan.close();

	}

//	public static void test (int a, int b) {
//		
//		int[] array= new int[a];  //a개의 배열을 만든다.
//	
//		
//		for(int i =0; i<a; i++){
//			int cnt = (int)(Math.random()*10)+1; //난수만들기
//			array[i]=cnt;
//			
//			if(array[i]<b) {
//				System.out.print(array[i]+" ");
//			}
//		}
//	}

	public static void prn(int num, int b) {

	
		System.out.println("배열");
		for (int i = 0; i < num; i++) {

			int nanSu = 0;
			nanSu = (int) (Math.random() * b) + 1;
			// System.out.print( nanSu + " ");
			System.out.println(nanSu);

			if (nanSu < b) {
				System.out.println("------");
				System.out.println("답 : " + nanSu);
				System.out.println("------");
			}
		}
	}
}
