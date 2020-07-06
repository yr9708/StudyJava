package com.palindrome;

import java.util.Scanner;

public class PalindromeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아무거나 입력해주세요 : ");
		String input = sc.next();
		
		if(isPalin(input)) {
			System.out.println(input + " : 회문이 맞습니다.");
		}else {
			System.out.println(input + " : 회문이 아닙니다");
		}
		
	}
	
	public static boolean isPalin(String input) {
//		char [] ch=input.toCharArray();
//		
//		
//		for(int i=ch.length-1; i>=0; i--) {
//			if(ch[i]==ch[ch.length-1-i]) {
//				return true;
//			}else {
//				return false;
//			}
//		}
		
		
		
		
		StringBuffer sb= new StringBuffer(input);
		sb.reverse();
		return input.equals(sb.toString())? true: false;


//		// 강사님 코드 (좋은 코드는 아닌데 설명하고자 사용함)
//		String reverse="";
//		for(int i=input.length(); i>0; i--) {
//			reverse += input.charAt(i-1);	// 해당 index 번지에 있는 char 값을 reverse라는 문자열에 더해주고있다.
//		}
//		return reverse.equals(input)? true : false;
		
		
		
		
		
		
		
	}

}
