package com.test06;

import java.util.Scanner;

public class Square extends AreaImpl {

	
	@Override
	public void print() {
		System.out.print("사각형의 ");
		super.print();
	}
	
	
	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("가로 길이를 입력해주세요");
		int a = sc.nextInt();
		System.out.println("세로 길이를 입력해주세요");
		int b = sc.nextInt();
		double d = (double) (a*b);
		String result = " "+d;
		super.setResult(result);
		
	}



}
