package com.test02;

public class TypeToType01 {

	public static void main(String[] args) {
		byte b1 = 100;
		int i1 = b1;			// 묵시적 형 변환 (upCasting, promotion) 작은 타입 -> 큰 타입
		
		System.out.println(i1);
		
		int i2 = 100;
		byte b2 = (byte)i2;			// 명시적 형 변환 (downCasting, casting) 큰 타입 - > 작은 타입
		
		System.out.println(b2);
		
		
	}

}
