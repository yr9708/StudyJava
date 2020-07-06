package com.test01;

public class MethodTest01 {

	public static void main(String[] args) {
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		defaultMethod();
		privateMethod();

	}

	public static void publicMethod() {
		System.out.println("public method");
		System.out.println("어디서나 접근, 참조 가능 (+)");
	}
	 
	protected static void protectedMethod() {
		System.out.println("protected method");
		System.out.println("상속인 경우, 상속된 곳에서 접근,참조 가능");
		System.out.println("상속이 아닌 경우 같은 패키지 내에서 접근, 참조 가능(#)");
	}
	
	static void defaultMethod() {
		System.out.println("defalut method");
		System.out.println("같은 패키지 내에서 접근, 참조 가능 (~)");
		
	}
	
	private static void privateMethod() {
		System.out.println("private method");
		System.out.println("현재 클래스 내에서만 접근, 참조 가능(-)");
	}
	
	public void nonStaticMethod() {
		System.out.println("non static method");
		System.out.println("객체 생성 필요!");
	}
	
}
