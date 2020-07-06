package com.test01;

public class ArrTest {
	public static void main(String[] args) {
		char[] ch = new char[26];
		char c = 'a';
		// 1. a ~ z를 1차원 배열에 저장 (반복문 사용)
		//	a b c d e f
		// g h i j k l 
		//	m n o p q r
		//	s t u v w x
		// y z
		// 출력
		for(int i =0; i<ch.length; i++) {
			ch[i]=c; 			// ch[i] = (char)('a'+i);
			c++;
		}
		prn(ch);
		
		// 2. 위에서 만든 배열을 거꾸로 출력
		
	
		reverse(ch);
		// 3. 1번에서 만든 배열을 대문자로 출력
		
		upper(ch);
		
		
		
		
//	
		
//		for (int i = 26; i <= ch.length; i--) {
//			if(i==0) {
//				break;
//			}
//				System.out.print(ch[i - 1] + " ");
//				if (i % 7== 0 && i%3==0) {
//					System.out.println();
//				
//			}
//		}
//		
	
//		System.out.println();
//		
//		for(int i=25; i>=0; i--) {
//			if(i%6==0) {
//				System.out.println();
//			}
//			System.out.print(ch[i]+" ");
//		}
		
		
	}
	
	public static void prn(char[] ch) {
		for(int i=1; i<=ch.length; i++) {
			System.out.print(ch[i-1]+" ");
			if(i%6==0) {
				System.out.println();
			}
		}
		
		System.out.println("\n");
	}
	
	
	public static void reverse(char[] ch) {
		
		int tmp =1;
		
		for(int i =ch.length; i>0; i--) {
			System.out.print(ch[i-1]+" ");
			if(tmp%6==0) {
				System.out.println();
			}
			tmp++;
		}
		System.out.println("\n");
	}
	
		
	public static void upper(char[] ch) {
		
		
		for(int i =1; i<=ch.length; i++) {
			System.out.print(Character.toUpperCase(ch[i-1])+" ");
			if(i%6==0) {
				System.out.println();
			}
		}
	}
	
	
	
}
