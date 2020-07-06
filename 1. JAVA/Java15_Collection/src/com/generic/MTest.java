package com.generic;

public class MTest {
	public static void main(String[] args) {
		
		Emp<String> aCompany = new Emp<String>();
		aCompany.setEmpno("A1111");
		aCompany.setEname("홍길동");
		
		Emp<Integer> bCompany = new Emp<Integer>(7890, "이순신");
		
		Emp cCompany = new Emp(123.456, "김선달");	// T : Object
		
		System.out.println(aCompany.getEmpno());
		System.out.println(bCompany.getEmpno());
		System.out.println(cCompany.getEmpno());
		
	}
}
