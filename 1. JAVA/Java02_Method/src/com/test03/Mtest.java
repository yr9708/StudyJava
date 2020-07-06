package com.test03;

public class Mtest {
	
	public static void main(String[] args) {
		MyCalc.sum(10,3); //argument
		
		int subRes = MyCalc.sub(10,3);
		System.out.println("10 - 3 = "+subRes);
		
		double mulRes = MyCalc.mul(10.2,3);
		System.out.println("10.2 * 3 = "+mulRes);
		System.out.println(MyCalc.mul(10.2,3));
		
		MyCalc.div(10,3);
		
	}
	
	
	
}
