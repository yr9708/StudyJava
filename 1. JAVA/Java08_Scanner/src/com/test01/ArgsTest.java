package com.test01;

public class ArgsTest {
	// (거의 사용하지 않음)
	// ran as -> run configurations -> arguments -> $(string_prompt)
	// main : 프로그램의 주 진입점
	public static void main(String[] args) {
		String s = args[0];
		System.out.println(s);
		
		// 메인메소드의 argument 넣고 싶을 때 모두 string타입으로 띄어쓰기를 기준으로 출력해줌
		
		for(int i=0; i<args.length; i++) {
			System.out.println("args : "+args[i]);
		}
	}
}
