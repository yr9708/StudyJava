package com.test04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		
		
		Map<Integer, String>map = new HashMap<Integer,String>();
		map.put(111,"one");
		map.put(112,"two");
		map.put(113,"three");
		map.put(114,"four");
		map.put(115,"five");
		map.put(111,"ONE");
		map.put(116,"ONE");
		
		System.out.println(map);		// 순서가 없음
		System.out.println(map.get(111));		
		prn(map);
	}
	
	
	public static void prn(Map<Integer,String> map) {
		Collection<String> values =map.values();
		System.out.println(values);
		
		Set<Integer> keys=map.keySet();
		System.out.println(keys);
		
		Set<Map.Entry<Integer, String>> entry = map.entrySet();
		for(Entry<Integer,String> e : entry) {
			System.out.printf("%d : %s\n", e.getKey(), e.getValue());
		}
		
		Iterator<Entry<Integer,String>> ir =entry.iterator();
		while(ir.hasNext()) {
			Entry<Integer,String> element = ir.next();
			if(element.getValue().equals("four")) {
				System.out.println(element.getKey());
			}
		}
		
		
	}
}	
