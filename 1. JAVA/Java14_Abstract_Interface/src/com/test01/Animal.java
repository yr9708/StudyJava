package com.test01;

// 추상 클래스 : 추상 메서드를 하나 이상 가질 수 있는 클래스
public abstract class Animal {
	
	// 추상 메소드 : body가 없는 메소드 -> 상속받는 자식 클래스가 반드시 구현!
	public abstract void bark();
	
	public void eat(String feed) {
		System.out.println(feed+" 먹는다.");
		
	}
	
	
	
}
