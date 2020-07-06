package com.test03;

public class Cat implements Animal {

	public Cat() {
		System.out.println("고양이는 "+KIND+" 이다" );
		
	}
	
	@Override
	public void bark() {
		System.out.println("야옹");

	}

	@Override
	public void eat(String feed) {
		System.out.println("고양이가 "+feed+" 먹는다.");

	}

}
