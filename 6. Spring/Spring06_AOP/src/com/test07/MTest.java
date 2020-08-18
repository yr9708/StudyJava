package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		// target bean 호출 하면 안되고 proxy로 호출해야됨
		MessageBean bean = factory.getBean("proxy",MessageBean.class);
		bean.sayHello();
		
		/*
		 타겟인척 하는 프록시
		 
		 AOP뭐하는애에요?
		 주 관심사항, 공통 관심사항으로 코드를 분리시킬거에요
		 그런 다음에 다시 붙어져야하는데 붙을 수 있는 위치들을 조인포인트
		 그 중에서 실제로 붙어질 곳을 포인트 컷이라고 하고
		 CCC코드를 ADVICE 라고 합니다.
		 이 CCC를 포인트컷과 같이 해서 ADVISOR 또는 ASPECT 라고 합니다.
		 이 모두를 묶어서 WEAVING 이라고 합니다.
		 
		 
		 */
	}
}
