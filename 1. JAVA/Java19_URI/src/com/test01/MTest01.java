package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {
	public static void main(String[] args) throws URISyntaxException {
		
		URI uri = new URI("http://localhost:8787/Java19_URI_Web/res.jsp?myname=%EA%B0%95%EC%97%AC%EB%A6%BC&myaddr=%EA%B2%BD%EA%B8%B0%EB%8F%84+%EA%B4%91%EC%A3%BC%EC%8B%9C");
		System.out.println(uri.getScheme());
		System.out.println(uri.getHost());
		System.out.println(uri.getPort());
		System.out.println(uri.getPath());
		System.out.println(uri.getQuery());
		
	}
}


/*
	java.net : URL, Address, UDP, TCP, ...
	
1. URI (Uniform Resource Identifier) : 식별자

2. URL (Uniform Resource Locator) : 주소 (위치)

3. URN (Uniform Resource Name) : 대상 (이름)

URI = URL + URN

	Rest (full) Api -> 따로 공부하기 , 카톡 신입 문제였음
	

*/