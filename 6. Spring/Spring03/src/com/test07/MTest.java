package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		System.out.println("Spring Bean Controller »ý¼º!");
	//	TV samsong = (TV)factory.getBean("samsong");
		TV igtv = (TV)factory.getBean("igtv");
//		samsong.powerOn();
//		samsong.powerOff();
//		samsong.volumeUp();
//		samsong.volumeDown();
		
		igtv.powerOn();
		igtv.powerOff();
		igtv.volumeUp();
		igtv.volumeDown();
	}
}
