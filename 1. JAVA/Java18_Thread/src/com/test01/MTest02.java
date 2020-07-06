package com.test01;


class MyThread02 extends Thread{

	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println("i : "+i);
		}
	}

}

public class MTest02 {
	public static void main(String[] args) {
		System.out.println("main Thread START");
		
		MyThread02 thread02 = new MyThread02();
		MyThread02 thread01 = new MyThread02();
		thread02.start();
		thread01.start();
		
		
		
		System.out.println("main Thread END");
		
	}
}
