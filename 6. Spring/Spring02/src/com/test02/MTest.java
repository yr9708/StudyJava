package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Address a = (Address)factory.getBean("������");
		System.out.println(a);
		
		Address b = (Address)factory.getBean("���ڿ�");
		System.out.println(b);
	}
}	
