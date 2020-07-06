package com.aaa;

// class AAA (extends Object)
public class AAA {
	// member : 클래스가 갖고 있는 것 (필드,메소드)
	
	
	// field : 속성
	private int abc;							// instance variable (non-static 객체를 생성해야 사용할 수 있는 변수), 하나하나 각자가 갖고 있는 변수
	public static String def = "test"; 	// class variable	(static 해당 클래스 전체에 적용된다), 해당 타입 전체에 적용되는 변수
	
	
	
	// 기본 생성자, 클래스에서 값을 만들때 생성자를 만들어서 사용
	public AAA() {
		// super();
		System.out.println("AAA 생성");
	}

	// 파라미터가 하나 있는 생성자
	public AAA(int abc) {					
		System.out.println("AAA 생성(abc 받아서 생성)");
		this.abc=abc; // 객체 생성하면서 field 를 초기화시켜주고있다. 
	}
	
	
	// method : 기능
	
	// getter & setter
	public int getAbc() {
		return abc;
	}
	
	public void setAbc(int abc) {
		this.abc=abc;		// 파라미터로 받은 abc를 field abc에 넣어줘라
	}
	
	public void prn() {
		System.out.println("AAA prn();메소드");
	}
	
	
	/*
	 * 
	 * <생성자>
	 * 1. 클래스 이름과 동일하되 리턴타입은 없고 객체 생성시 접근제한자는 public 
	 * 	class Test{
	 * 		public Test(){ 	// 생성자
	 * 	}
	 * }
	 * 
	 * 2. 생성자는 객체 생성을 하는 new 연산자와 함께 사용되며 생성시 단 한번만 자동호출된다.
	 * Test t1 = new Test();	// (o) -> 기본 생성자 호출
	 * 
	 * 3. 생성자는 메소드 처럼 객체 및 클래스 명으로 호출할 수 없다.
	 * t1.Test();						// (x)
	 * Test.Test();					// (x)
	 * 
	 * 4. overload 할 수 있다.
	 * class Test{			
	 * 	public Test(){			// 기본 생성자
	 * 	}
	 * 	public Test(int a){
	 * 	}
	 * 	public Test(int a, int b){
	 * 	}
	 * 	...
	 * }
	 * 
	 * 5. ★ 생성자를 명시하지 않으면 기본 생성자가 제공되어 필드를 초기화 하고 
	 * 	생성자를 명시하면 명시한 생성자만 호출되고
	 * 	기본 생성자는 제공되지 않는다 ★
	 * 
	 * class AA{		//AA aa = new AA(); (o)
	 *
	 * }
	 * 
	 * 
	 * class BB{
	 * 	public BB(){	// BB b = new BB(); (o)
	 * 				
	 * 	}
	 * }
	 * 
	 * class CC{
	 * 	public CC(int a){	// CC c  = new CC(); (x)
	 * 								// CC c = new CC(10); (o)
	 * 	}
	 * }
	 * 
	 * 
	 * 6. 생성자는 상속되지 않는다.
	 * 
	 * 7. 생성자는 내무 호출 할 수 있다.
	 * 	this();
	 * 
	 * 8. 생성자의 목적 : 객체 생성, 필드 초기화
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
}
