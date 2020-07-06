package com.test02;

import com.test01.MethodTest01; 

public class MethodTest03 {

	public static void main(String[] args) {
		MethodTest01.publicMethod();
	//	MethodTest01.protectedMethod();
	//	MethodTest01.defaultMethod();
	//	MethodTest01.privateMethod();
		
		MethodTest01 method = new MethodTest01();
		method.nonStaticMethod();
		
		
	}

}
