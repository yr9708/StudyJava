package com.test02;

public class Cat extends Animal{
	public Cat() {
		System.out.println("고양이");
	}
	
	// Annotation
	// 재정의 : 부모 클래스의 메소드를 자식 클래스가 확장
	@Override
	public void bark() {
		System.out.println("야옹");
	}
	
	
	
	
	
}
