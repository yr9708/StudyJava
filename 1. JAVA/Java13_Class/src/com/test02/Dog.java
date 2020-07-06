package com.test02;

public class Dog extends Animal{
	public Dog() {
		System.out.println("댕댕잉");
	}
	
	public void bark() {
		super.bark();
		System.out.println("와랄랑라랄");
	}
}
