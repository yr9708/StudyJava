package com.singleton;

public class MTest {
	public static void main(String[] args) {
		//	Singleton s = new Singleton();
		
		Singleton singleton= Singleton.getInstance(); // 객체생성
		System.out.println(singleton);
		
		Singleton s = Singleton.getInstance();
		System.out.println(s);
		
		System.out.println(singleton==s);
		
	}
}
