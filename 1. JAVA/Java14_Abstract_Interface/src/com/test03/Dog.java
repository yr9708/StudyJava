package com.test03;

public class Dog implements Animal {

	
	public Dog() {
	// 	KIND="멍멍이";
	}
	@Override
	public void bark() {
		System.out.println("멍멍");

	}

	@Override
	public void eat(String feed) {
		System.out.println("댕댕이가 "+feed+" 먹는다.");

	}

}
