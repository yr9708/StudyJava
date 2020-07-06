package com.test01;

public class MTest04 {
	public static void main(String[] args) {
		
		MyThread03 cat= new MyThread03("야옹이");
		MyThread03 dog = new MyThread03("댕댕이");
		
		long startTime = System.currentTimeMillis();
		
		cat.start();
		try {
			// thread가 종료될 때 까지 다른 thread를 멈춤
			cat.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		dog.start();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("실행시간 : "+(endTime-startTime));
		
		
	}
}
