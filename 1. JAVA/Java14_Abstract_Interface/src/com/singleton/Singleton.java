package com.singleton;

// 메모리(heap)에 객체를 한번만 생성
public class Singleton {
	
	// 2. 객체를 확인할 주소(reference) 선언
	private static Singleton singleton;
	
	// 1. 외부에서 객체를 생성할 수 없도록, 생성자를 private으로 만든다.
	private Singleton() {
		System.out.println("Singleton instance 생성");
	}
	
	// 3. 객체 생성 메서드
	public static Singleton getInstance() {
		if(singleton==null) {
			System.out.println("new!!");
			singleton=new Singleton();
		}
		
		return singleton;
	}
}
