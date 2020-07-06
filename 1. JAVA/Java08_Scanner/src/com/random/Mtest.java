package com.random;

import java.util.Random;

public class Mtest {
	public static void main(String[] args) {
	//	mathClass();
	//	minMax();
		randomClass();
	}
	public static void mathClass() {
		// 0.0 <= x <1.0
		double ran= Math.random();
		System.out.println(ran);
		
		//(Math.random()*(max - min+1))+min;
		int i =(int)(Math.random()*10);
	}
	
	public static void minMax() {
		// 10~100사이의 난수 발생
		// min 시작점 (10이라고 지정)
		
		int min = 10;
		int max = 100;
		int rd = (int)(Math.random()*(max-min))+min;
		
	//	int  i = (int)(Math.random()*100);
		System.out.println(rd);
	}
	
	public static void randomClass() {
		Random rd = new Random();
		System.out.println(rd.nextInt(100));
	}
}
