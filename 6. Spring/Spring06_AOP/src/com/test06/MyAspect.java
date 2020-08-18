package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * *(..))")
	public void qClass() {}
	
	@Before("qClass()")
	public void Before() {
		System.out.println("출석카드를 찍는다.");
	}
	
	@After("qClass()")
	public void After() {
		System.out.println("집에 간다.");
	}
}
