package com.point;

import java.util.Scanner;

public class PointLength {
/*
 *  원점 (0,0)부터 입력한 (x,y)까지의 거리를 구하자.
 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("x값을 입력해주세요");
		int x = sc.nextInt();
		System.out.println("y값을 입력해주세요");
		int y = sc.nextInt();
		

		System.out.printf("(0,0)과 (%d,%d)의 거리는 %f 입니다.",x,y,pLength(x,y));
		
	}
	
	public static double pLength(int x, int y) {
		
		
		// len = root(x*x + y*y);
		// len = root((Math.pow(x,2)+Math.pow(y,2));
		
	//	double sum=Math.pow(x,2)+Math.pow(y,2); //제곱해주기
		
		double len = Math.hypot(x, y);
		
		return len; // 루트 씌워서 보내기
		
		
		
	}

}
