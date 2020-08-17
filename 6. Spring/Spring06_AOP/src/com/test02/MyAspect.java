package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// invoation -> w.classwork (����æmothod) 
		Object target = null;
		System.out.println("�⼮ ī�带 ��´�.");
		try {
			target = invocation.proceed();
		} catch (Throwable e) {
			System.out.println("���� ���̾���.");
		}
		System.out.println("���� ����.");
		
		return target;
	}

}
