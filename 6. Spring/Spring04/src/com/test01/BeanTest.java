package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanTest {
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("�⺻ ������");
	}
	
	public BeanTest(Date date) {
		System.out.println("Date �޴� ������ : "+date);
	}
	
	public BeanTest(MyClass myClass) {
		this.myClass=myClass;
		System.out.println("MyClass �޴� ������");
	}
	
	public void setMyClass(MyClass myClass) {
		this.myClass= myClass;
		System.out.println("setMyClass(MyClass myClass) ȣ��!");
	}
	
	public void setDate(Date date) {
		System.out.println("setDate(Date date) ȣ��! " + date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber(int num) ȣ�� : "+num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("setArray(String[] arr) ȣ��");
		for(String s : arr) {
			System.out.println(s);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("setList(List<String> list) ȣ��");
		System.out.println(list);
	}
	
	public void setSet(Set<String> set) {
		System.out.println("setSet(Set<String> set) ȣ��");
		for(String s: set) {
			System.out.println(s);
		}
	}
	
	public void setMap(Map<String, String>map) {
		System.out.println("setMap(Map<String, String>map) ȣ��");
		/*
		 * Collection<String> values = map.values(); 
		 * for(String value : values) {
		 * System.out.println(value); 
		 * }
		 */
		
		// key = value ��� (Entry ����°ſ���)
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String,String> entry : entrySet) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore(List<Score> list) ȣ��");
		for(Score sc : list) {
			System.out.println(sc);
		}
	}
}
