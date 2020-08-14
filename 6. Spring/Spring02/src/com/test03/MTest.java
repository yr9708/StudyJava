package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Address lee = (Address)factory.getBean("lee");
		Address hong = (Address)factory.getBean("hong");
		System.out.println(lee);
		System.out.println(hong);
		
		// ApplicationContext 에는 close() 메소드가 없는데
		// ClassPathXmlApplicationContext 에는 close() 메소드가 있기 때문에
		// 자식클래스로 형변환 해주고 close() 사용
		((ClassPathXmlApplicationContext)factory).close();
	}
}
