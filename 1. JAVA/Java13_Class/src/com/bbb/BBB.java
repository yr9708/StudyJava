package com.bbb;

import com.aaa.AAA;

// BBB 클래스는 AAA 클래스를 상속 받았다.
public class BBB extends AAA {

	private int b;
	
	public BBB() {
		// super(); - 명시해주지 않으면 기본적으로 부모 생성자가 만들어진다.
		System.out.println("BBB 생성");
	}
	
	public BBB(int b) {
		// super();
		this.b=b;
		System.out.println("BBB 생성(b받아서 생성)");
	}
	
	public BBB(int abc, int b) {
		// super();
		super(abc);	// AAA의 abc
		this.b=b;
		System.out.println("BBB생성(abc,b받아서 생성)");
	}
	
	// getter & setter
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b=b;
	}
	
	public int getSum() {
		int sum = super.getAbc()+this.getB();	// super.  ,   this.는 생략은 가능하다 부모에게 상속받은 메소드를 바로 사용할 수 있다.
		
		return sum;
	}
	
	public void prn() {
		System.out.println("BBB prn()!!!");
	}
	
	
	
	
	
}
