package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// 기존 방식
		// 1. 
		// Resource res = new FileSytemResource("src/com/test03/beans.xml");
		// 2.
		// Resource res = new FilePathResource("com/test03/beans.xml");
		// BeanFactory factory = new XmlBeanFactory(res); -> bean을 만들어주는 것
		// 3. 최근방식
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		// ClassPath에 xml 파일이 있는데 ApplicationContext 객체를 만들거야 ("이경로에 있는");
		MessageBean english = (MessageBean)factory.getBean("bean01");
		MessageBean korean = (MessageBean)factory.getBean("bean02");
		// 어떤 객체가 bean으로 만들어질지 모르기때문에 object 로 만들어질거야 
		// 그래서 (MessageBean) 으로 형변환 시켜
		
		english.sayHello("Spring");
		korean.sayHello("스프링");
		
/*

BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext
스프링의 ApplicationContext 객체는 스프링 컨테이너 인스턴스이다.
스프링은 ApplicationContext 인터페이스의 여러 객체를 제공한다.
ClassPathXmlApplictionContext: 지정된 ClassPath에서 xml파일을 읽어서 bean 생성한다.

loc : 제어 역전(역전제어/ 제어반전)
-> 객체 생성 != 사용하는 곳
원래는 객체를 생성해서 사용했었는데 이제는 spring에서 객체를 생성하고 사용은 java code에서 사용한다.

interface 를 사용하는 것과 spring을 사용하는 것
-> 결합도가 약하다



 */
		
	}
}
