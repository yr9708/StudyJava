package com.test04;

public class Cat extends Animal{

	@Override
	public void bark() {
		System.out.println("야옹");
	}
	
	@Override
	public void eat(String feed) {
		System.out.println("고양희가 "+feed+" 먹는다.");
	}

}
