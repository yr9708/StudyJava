package com.test04;

public class Woman implements Person {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 쇼핑한다.");
		return "Spring";
	}

}
