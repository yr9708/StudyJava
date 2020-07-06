package com.test02;

public class TypeToType02 {

	public static void main(String[] args) {
		int i = 65;
		char c = (char)i;
		System.out.println(c);
		
		char c2 = 'B';
		int i2 = (int)c2;
		System.out.println(i2);
		
		char c3_1='9';		// 57
		char c3_2='1';		// 49
		int i3 = c3_1 + c3_2; 
		System.out.println(i3);
		
		String str = "65";
		System.out.println(str+1);
		int i4 = Integer.parseInt(str);
		System.out.println(i4+1);
		
		
		int i5 = 65;
		String str2 = String.valueOf(i5);
		System.out.println(str2+1);
		
		String str3 = Integer.toString(i5);
		System.out.println(str3+2);
		
	}


}
