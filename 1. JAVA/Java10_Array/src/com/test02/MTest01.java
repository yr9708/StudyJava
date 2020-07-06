package com.test02;

import java.util.Arrays;

public class MTest01 {
	public static void main(String[] args) {
		int[] original = {10, 20, 30, 40};
		int[] copy = original;			// reference(주소값) 복사
		
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		
		System.out.println(original == copy);
		
		copy[1]=22;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		System.out.println(original.hashCode());
		System.out.println(copy.hashCode());
		
		
		
		
		
	}
}
