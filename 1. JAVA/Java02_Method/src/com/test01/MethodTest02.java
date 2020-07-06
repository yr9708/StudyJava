package com.test01;

public class MethodTest02 {

	// method 호출 방법
	public static void main(String[] args) {
		// 1. static : Class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
	//	MethodTest01.privateMethod(); -private은 현재 클래스 내애서만 접근, 참조 가능->현재 클래스에는 존재 하지 않음
		
		// 2. non static : Class(type) 변수 = new Class();
		//						변수.method();
		MethodTest01 myNonStatic = new MethodTest01(); // 클래스를 객체로 만드는 것
		myNonStatic.nonStaticMethod();
		
		// https://www.objectaid.com/home
		// UML (Unified Modeling Language) : 설계
		
		
		

	}

}
