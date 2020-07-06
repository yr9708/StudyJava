package com.test02;

public class MTest01 {
	public static void main(String[] args) {
		
		StringTest();
		StringBufferTest();
	}
	
	public static void StringTest() {
		String s = "안녕하세요.";
		System.out.println(s.hashCode());
		s += "저는 ";
		s +="짱여림 입니다.";
		System.out.println(s.hashCode());
		System.out.println(s);
		// 값은 변하지 않는다. (immutable)
		
		s.replace("안녕하세요.", "하이!");
		System.out.println(s);
		System.out.println(s.hashCode());
		
		s=s.replace("안녕하세요.", "하이!");
		System.out.println(s);
		System.out.println(s.hashCode());
		System.out.println("--------------------");
	}
	
	public static void StringBufferTest() {
		StringBuffer sb = new StringBuffer("안녕하세욘. ");	
		System.out.println(sb.hashCode());							// 값만 변하니까(mutable) 주소값은 변하지 않음.
		
		sb.append("저는 ").append("강여림" ).append("입니다."); //메소드 체이닝
		
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		sb.replace(0, 5, "하염!");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}
	
}
