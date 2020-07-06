package com.test02;

public class SleepTest {
	public static void main(String[] args) {
		while(true) {
			for(int i = 0; i<11; i++) {
				try {
					Thread.sleep(1000);	 // 1초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("♥");
			}
			System.out.println();
		}
	}
}
