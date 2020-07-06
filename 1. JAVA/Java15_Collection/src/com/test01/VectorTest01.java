package com.test01;

import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<Integer>(10,5);	// List를 상속받아서 배열같이 사용할 수 있다. (But 배열은 크기고정, Vector는 크기가 변함)
		System.out.println(v.size()+" : "+v.capacity());

		for(int i=0; i<9; i++) {
			v.add(i);
		}
		
		System.out.println(v.size()+" : "+v.capacity()); 	// capacity 최대용량
		System.out.println(v);
		
		
		v.add(9);
		System.out.println(v.size()+" : "+v.capacity());
		System.out.println(v);
		
		v.add(10);
		System.out.println(v.size()+" : "+v.capacity());
		System.out.println(v);
	}
}
