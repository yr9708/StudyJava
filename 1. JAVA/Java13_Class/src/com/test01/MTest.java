package com.test01;

public class MTest {
	public static void main(String[] args) {
		AA a = new AA();
		Super s = a;
		
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
		
		AA a1 = (AA) s;
		System.out.println(a1.hashCode());
		
		BB b1 = (BB) s;					
		System.out.println(b1.hashCode()); // 컴파일은 되는데 ClassCastException (형변환 불가)
		

	}
}
