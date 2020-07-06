package com.test03;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("3");
		set.add("4");
		set.add("6");
		set.add("5");

		System.out.println(set);	// 정렬된것이 아님. set은 순서가 없다. 중복이 안된다. 
		
		
		findElement(set,"4");
		removeElement(set,"4");
		System.out.println(set);
	}
	
	public static void findElement(Set<String>set, String find) {
		for(String element : set) {		// set은 순서가 없기 때문에 index를 알 수가 없음. for문 사용 못함
			if(element.equals(find)) {
				System.out.println(find +" 찾았다!");
			}
		}
		
	}
	
	
	
	public static void removeElement(Set<String>set, String remove) {
		for(String element : set) {
			if(element.equals(remove)) {
				set.remove(element);
				break;
			}
		}
		
		
	}
}
