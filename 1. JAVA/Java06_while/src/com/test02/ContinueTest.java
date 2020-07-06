package com.test02;

public class ContinueTest {
	public static void main(String[] args) {
		prn();
	}
	
	public static void prn() {
		int i = 0;
		while(i<11) {
			i++;
			
			if(i%2==0) {
				continue; // 밑의 코드를 실행하지 않고 해당 조건을 확인하러 올라감. 
			}
			
			System.out.println(i);
		}
	}
}
