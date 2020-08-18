package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("�⼮ī�带 ��´�.");
	}
	
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("���� ����.");
	}
	
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("���� ���̾���.");
	}
	
	@AfterReturning(pointcut = "execution(public * *(..))", returning="returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + "�����ϴ� ���̾���.");
		
		// Ÿ�ٿ��� ���ϵǴ� ���� �޾Ƽ� ����ϴ� ��
	}
}
