package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Person w = factory.getBean("woman", Person.class);
		Person m = (Person)factory.getBean("man");
		System.out.println("���л� ����");
		w.classWork();		
		System.out.println("------------------");
		System.out.println("���л� ����");
		m.classWork();
	}
}