package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Before("qClass()")
	public void before() {
		System.out.println("출석카드를 찍는다.");
	}
	
	@After("qClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	@Pointcut("execution(public * *(..))") 
	public void qClass() { // qClass 이름으로 pointCut을 대신하겠다. 그래서 before랑 after에 qClass 이름 써준거 (한번에 포인트컷을 걸어 줄 수 있다)
		
		
	}
}
