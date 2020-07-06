package com.test01;

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println("i : "+i);
		}
	}
	
}

public class MTest01 {
	public static void main(String[] args) {
		// main thread가 가장 먼저 (우선순위 높다)

		System.out.println("-------program Start-------");
//		MyThread thread01 = new MyThread();
//		MyThread thread02 = new MyThread();
//		thread01.run();
//		thread02.run();
		
		
		
		
		Thread thread01 = new Thread(new MyThread());
		Thread thread02 = new Thread(new MyThread());
		thread01.start();
		thread02.start();
		System.out.println("-------program End---------");
		
	}
}
