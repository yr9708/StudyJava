package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		Person w = (Person)factory.getBean("woman");
		Person m = factory.getBean("man",Person.class);
		
		System.out.println("여학생 입장");
		w.classWork();
		System.out.println("--------------");
		System.out.println("남학생 입장");
		m.classWork();
		
		// before 찍고
		// 타겟 찍고
		// AfterRetuning : target이 정상적으로 작동 후 return 해주는 값을 받아서 동작한다.
		// AfterThrowing : target이 비정상적으로 종료되면 (=예외가 발생하면) 동작한다.
		// after 찍는다.
	}
}
