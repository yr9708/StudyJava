package com.baseball;

import java.util.Scanner;

public class User {
	private int[] inputArr;
	private int size;
	
	public User() {
		size=3;
		inputArr = new int[size];
	
	}
	
	public User(int size) {
		this.size=size;
		inputArr = new int[size];
	}
	
	public int[] input() {
		System.out.println(size+" 자릿수의 숫자를 입력해주세요");
		System.out.println("(각 숫자는 공백으로 구분)");
		
		Scanner sc = new Scanner(System.in);
		String [] input=sc.nextLine().split(" ");
		for(int i=0; i<inputArr.length; i++) {
			inputArr[i]=Integer.parseInt(input[i]);
		}
		
		
		return inputArr;
	}
	
	
	
	
	
	
	
	
	
	
}
