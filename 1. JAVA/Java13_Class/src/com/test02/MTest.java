package com.test02;

public class MTest {
	public static void main(String[] args) {
		/*
		Cat cat  =  new Cat();
		Dog dog = new Dog();
		
		cat.bark();
		dog.bark();
		
		*/
		
		// 다형성
		Animal someone = new Dog();
		someone.bark();
		
		someone = new Cat();
		someone.bark();
		System.out.println("-------------");
		
		// instanceof
		if(someone instanceof Dog) {
			System.out.println("댕댕이");
		}else if(someone instanceof Cat){
			System.out.println("야옹이");
		}
		
		/*
		 * 
		 * 다형성
		 * 
		 * 1. 부모 타입으로 자식생성
		 * Parent p = new Child();
		 * 
		 * 2. 부모 이름으로 자식 대입
		 * Child c = new Child();
		 * Parent p = c;
		 * 
		 * 3. 부모의 메서드를 통해 자식 메서드 호출
		 * 
		 * 같은 부모를 갖고 있는 자식 클래스는 컴파일시 형변환 가능하지만 런타임시 ClassCastException 발생
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
	}
}
