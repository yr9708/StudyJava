package com.test02;

public class TypeToType03 {

	public static void main(String[] args) {
		// boxing : 기본 타입 값을 레퍼타입으로 감싸는 것
		Integer i = new Integer(100);
		
		// unboxing
		// 명시적
		int j = i.intValue();
		System.out.println(j);
		
		// 묵시적
		int k = i;
		System.out.println(k);
	}

}
