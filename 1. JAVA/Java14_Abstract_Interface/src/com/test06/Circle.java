package com.test06;

import java.util.Scanner;

public class Circle extends AreaImpl {
	
	
	
	
	@Override
	public void print() {
		System.out.print("원의 ");
		super.print();
	}


	
	
	@Override
	public void make() {
		System.out.println("반지름을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		double d = (double) r*r*Math.PI;
		// String result = String.valueOf(d);
		// Double.toString(d);
		// super.setResult(result);
	 	setResult(String.format("%.2f",d));
		
	}



}
