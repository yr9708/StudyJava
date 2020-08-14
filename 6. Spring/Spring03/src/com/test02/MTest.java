package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Emp kim = (Emp)factory.getBean("kim");
		Emp Wook = factory.getBean("Wook",Emp.class);
		
		System.out.println(kim);
		System.out.println(Wook);
	}
}
