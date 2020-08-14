package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		MyClass my =(MyClass) factory.getBean("myClass");
		my.prn();
		
		Date date = (Date)factory.getBean("date");
		System.out.println(date);
		
		
	}
}
