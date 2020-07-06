package com.test04;

public class MTest {
	public static void main(String[] args) {
		Animal cat = new Cat();
		cat.bark();
		cat.eat("츄르");
		
		Animal dog = new Dog();
		dog.bark();
		dog.eat("뼈다구");
		((Dog)dog).bite(); // 부모타입이 더 큰 type 이기 때문에 형변환을 시켜줘야한다.
		
		Animal eagle = new Eagle();
		eagle.bark();
		eagle.eat("쥐");
		((Eagle) eagle).fly();
	}
}
