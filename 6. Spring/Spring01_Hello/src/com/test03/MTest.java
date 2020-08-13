package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// ���� ���
		// 1. 
		// Resource res = new FileSytemResource("src/com/test03/beans.xml");
		// 2.
		// Resource res = new FilePathResource("com/test03/beans.xml");
		// BeanFactory factory = new XmlBeanFactory(res); -> bean�� ������ִ� ��
		// 3. �ֱٹ��
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		// ClassPath�� xml ������ �ִµ� ApplicationContext ��ü�� ����ž� ("�̰�ο� �ִ�");
		MessageBean english = (MessageBean)factory.getBean("bean01");
		MessageBean korean = (MessageBean)factory.getBean("bean02");
		// � ��ü�� bean���� ��������� �𸣱⶧���� object �� ��������ž� 
		// �׷��� (MessageBean) ���� ����ȯ ����
		
		english.sayHello("Spring");
		korean.sayHello("������");
		
/*

BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext
�������� ApplicationContext ��ü�� ������ �����̳� �ν��Ͻ��̴�.
�������� ApplicationContext �������̽��� ���� ��ü�� �����Ѵ�.
ClassPathXmlApplictionContext: ������ ClassPath���� xml������ �о bean �����Ѵ�.

loc : ���� ����(��������/ �������)
-> ��ü ���� != ����ϴ� ��
������ ��ü�� �����ؼ� ����߾��µ� ������ spring���� ��ü�� �����ϰ� ����� java code���� ����Ѵ�.

interface �� ����ϴ� �Ͱ� spring�� ����ϴ� ��
-> ���յ��� ���ϴ�



 */
		
	}
}
