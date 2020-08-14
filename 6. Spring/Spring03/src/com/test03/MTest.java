package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Emp kim = (Engineer)factory.getBean("kim");
		Emp wook = (Developer)factory.getBean("wook");
		
		System.out.println(kim);
		System.out.println(wook);
	}
}
