package com.test02;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
	public static void main(String[] args) {
//		List list = new ArrayList();
//		// list.add("String");
//		list.add("100");
//		list.add("101");
//		list.add(null);
//		System.out.println(list);
//		
//		for(int i =0; i<list.size(); i++) {
//			System.out.println(Integer.parseInt(list.get(i)+""));
//		}
		
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("이순신");
		list.add("김선달");
		list.add("이제훈");
		list.add("서강준");
		list.add("차은우");
		list.add("박보검");
		
		trans(list);
		
	}
	
	
	public static void trans(List<String> list) {
		// 1. "홍길동"을 "김길동"으로 바꾸자
		list.set(list.indexOf("홍길동"),"김길동");
		System.out.println(list);
		
		// 2. ~신으로 끝나는 객체를 찾아서 ~자로 바꾸자
		for(int i=0; i<list.size();i++) {
			if(list.get(i).endsWith("신")) {
				list.set(i, list.get(i).replace("신", "자"));
			}
		}
		System.out.println(list);
		
		
		// 3. "훈"으로 끝나는 객체를 찾아서 삭제하자
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).endsWith("훈")) {
				list.remove(i);
			}
		}
		
		System.out.println(list);
		
	}
}
