package com.test01;

public class Dog extends Animal {

	@Override
	public void bark() {
		System.out.println("멍멍");
	}
	
	
	@Override
	public void eat(String feed) {
		System.out.println("멍멍이가 "+feed+" 냠냠긋");
	}
	
	
}
