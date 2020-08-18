package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		Person woman = (Person)factory.getBean("woman");
		Person man = factory.getBean("man", Person.class);
		
		System.out.println("���л� ����");
		woman.classWork();
		System.out.println("-------------");
		System.out.println("���л� ����");
		man.classWork();
	}
}
