package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Before("qClass()")
	public void before() {
		System.out.println("�⼮ī�带 ��´�.");
	}
	
	@After("qClass()")
	public void after() {
		System.out.println("���� ����.");
	}
	
	@Pointcut("execution(public * *(..))") 
	public void qClass() { // qClass �̸����� pointCut�� ����ϰڴ�. �׷��� before�� after�� qClass �̸� ���ذ� (�ѹ��� ����Ʈ���� �ɾ� �� �� �ִ�)
		
		
	}
}
