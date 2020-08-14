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
		
		// ApplicationContext ���� close() �޼ҵ尡 ���µ�
		// ClassPathXmlApplicationContext ���� close() �޼ҵ尡 �ֱ� ������
		// �ڽ�Ŭ������ ����ȯ ���ְ� close() ���
		((ClassPathXmlApplicationContext)factory).close();
	}
}
