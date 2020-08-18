package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		Person w = (Person)factory.getBean("woman");
		Person m = factory.getBean("man",Person.class);
		
		System.out.println("���л� ����");
		w.classWork();
		System.out.println("--------------");
		System.out.println("���л� ����");
		m.classWork();
		
		// before ���
		// Ÿ�� ���
		// AfterRetuning : target�� ���������� �۵� �� return ���ִ� ���� �޾Ƽ� �����Ѵ�.
		// AfterThrowing : target�� ������������ ����Ǹ� (=���ܰ� �߻��ϸ�) �����Ѵ�.
		// after ��´�.
	}
}
