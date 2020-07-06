package com.test02;

public class Cat extends Animal{

	@Override
	public void start() {
		System.out.println("고양이 걸어");
		
	}

	@Override
	public void stop() {
		System.out.println("고양이 멈춰");
		
	}
	
}
