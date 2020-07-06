package com.test01;

public class Type05 {

	/*
	 * 기본타입(값 자체) call by value		-> 	참조타입(주소값 - 기능) call by reference
	 * byte												Byte
	 * short												Short
	 * int													Integer
	 * long												Long
	 * float 												Float
	 * double											Double
	 * char												Character
	 * boolean											Boolean
	 * 														<Wrapper Class>
	 * 
	 * 
	 * 
	 * 참조타입 변수 = 주소 값 (객체)
	 *
	 */
	public static void main(String[] args) {
		System.out.println("byte의 범위 : " + Byte.MIN_VALUE + " ~ "+ Byte.MAX_VALUE);
		System.out.println("short의 범위 : "+ Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int의 범위 : "+ Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		
		System.out.println("float의 범위 : "+ Float.MIN_VALUE+" ~ "+Float.MAX_VALUE);
		System.out.println("double의 범위 :" + Double.MIN_VALUE+" ~ "+Double.MAX_VALUE);
		
		System.out.println("Character의 크기 : " +Character.SIZE);
	
		
	}

}
