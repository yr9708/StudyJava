package com.test02;

import java.util.Scanner;

public class MTest {
	public static void main(String[] args) {
		
		int a = 0;
		
		try {
			System.out.println("숫자를 입력해주세요");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			
			System.out.println(a + 10);
			
			if(a==7) {
				throw new MyException(); // 예외를 발생시킴
			}else if(a==29) {
				throw new MyException("29 시렁");
			}
			
		}catch(MyException e) {
//			e.printStackTrace();
			System.out.println("내가 발생시킨 예외");
		}catch(Exception e) {	// 예외를 파악하는ㄷ에 시간이 걸리게 됨, 번거로움
//			e.printStackTrace();
			System.out.println("가장 큰 예외");
		}
	}
}
