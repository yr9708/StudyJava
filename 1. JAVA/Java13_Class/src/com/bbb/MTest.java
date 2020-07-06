package com.bbb;

import com.aaa.AAA;

public class MTest {
	public static void main(String[] args) {
		AAA aaa = new AAA();		
		aaa.prn();
		AAA aaa01=new AAA(100);
		
		System.out.println(aaa.getAbc());
		System.out.println(aaa01.getAbc());
		System.out.println("-------------");
		
		BBB b01 = new BBB(); // 부모의 객체를 따로 호출하지 않아도 자동으로 호출된다.(부모가 있어야 자식이 있다)
		// b01은 부모의 주소값을 갖고 있다.
		
		b01.setAbc(10);
		b01.setB(20);
		System.out.println(b01.getSum());
		
		BBB b02 = new BBB(30);
		b02.setAbc(40);
		System.out.println(b02.getSum());
		System.out.println("-------------");
		
		BBB b03 = new BBB(50,60);
		System.out.println(b03.getSum());
		System.out.println("-------------");
		
		AAA a1 = new AAA();
		AAA a2 = new BBB();	// 부모 > 자식 , AAA > BBB, 재정의 override
		
		// a2.getB();  사용할 수 없음
		
		a1.prn();
		a2.prn();
		System.out.println("-------------");
		
		
		// BBB b = new AAA(); 부모타입이 자식객체를 담을 순 있지만, 자식타입이 부모객체를 담을 순 없다.
	
		
		
		
		
	}
}
