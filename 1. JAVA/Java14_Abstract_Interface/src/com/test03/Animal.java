package com.test03;

// 모든 메소드가 추상 메소드
public interface Animal {
	
	
	// interface 안에 있는 변수는 상수화,일반적으로 대문자로 사용 (변하지 않는다)
	String KIND ="동물";
	
	public void bark();
	void eat(String feed);
	
	
}
