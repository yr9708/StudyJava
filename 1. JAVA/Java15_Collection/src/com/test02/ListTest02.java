package com.test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<11; i++) {
			list.add(i+"");
		}
		
	//	System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		//Collections.sort(list); -> 문자열이기 때문에 1, 다음에 10 다음에 2가 오는게 맞음

		Collections.sort(list, new MySortTest());
		System.out.println(list);	
		
		
		
	}
}


class MySortTest implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
	
		int tmp01 = Integer.parseInt(o1);
		int tmp02 = Integer.parseInt(o2);
		
		if(tmp01 > tmp02) {
			return 1;
		}else if(tmp01 < tmp02) {
			return -1;
		}
			
		return 0;
		
	
	}
	
}
