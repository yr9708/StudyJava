package com.test01;

import java.util.Vector;

public class VectorTest02 {
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		
		v.add("홍길동");
		v.add("이순신");
		v.add("김선달");
		v.add("이제훈");
		v.add("서강준");
		v.add("차은우");
		v.add("박보검");
		prn(v);
		trans(v);
	
	}
	
	public static void prn(Vector<String> vector) {
		// 향상된 for문 , forEach문
		for(String element : vector) {
			System.out.print(element+" ");
		}
		System.out.println();
		
		
	}
	
	public static void trans(Vector<String> vector) {
		
		//1. 홍길동의 인덱스를 찾고 해당 인덱스에 있는 값을 "홍길순"으로 바꾸자
		
			
		int a = vector.indexOf("홍길동");
		vector.set(a, "홍길순");
		System.out.println("인덱스 : "+a);
		System.out.println(vector);
		
		// vector.set(vector.indexOf("홍길동"), "홍길순");
		
		
		//2. "~~신"으로 끝나는 객체를 찾고 만약 있다면 "신"을 "자" 로 바꾸자.
		
		
		
		for(int i=0 ; i<vector.size(); i++) {
			if(vector.get(i).endsWith("신")) {
				vector.set(i, vector.get(i).replace("신", "자"));
				// i = vector.indexOf(vector.get(i))
			}
		}
			
		System.out.println(vector);
		
		
		
		//3. 마지막 글자가 "훈" 인 이름을 찾고 만일 있다면 삭제하자
		for(int i=0 ; i<vector.size(); i++) {
			if(vector.get(i).endsWith("훈")) {
				vector.remove(i);
			}
		}
		
		System.out.println(vector);
		
//		for(String element : vector) {
//			if(element.endsWith("훈")) {
//				vector.remove(element);		// ConcurrentModificationException
//														//	element 자체는 삭제되거나, 변경되서는 안되기 때문에 오류가 남. 
//			}
//		}
		
		
		

		
	}
}
