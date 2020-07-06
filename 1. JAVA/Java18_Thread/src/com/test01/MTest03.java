package com.test01;

class MyThread03 extends Thread{
	
	public MyThread03(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i =0 ; i<1000; i++) {
			System.out.println(this.getName() + " : "+i);
		}
		System.out.println("-----"+this.getName()+"------");
	}
	
}


public class MTest03 {
	public static void main(String[] args) {
		
		MyThread03 dog = new MyThread03("멍멍이");
		MyThread03 cat = new MyThread03("야옹이");
	
		
		// thread scheduling : 우선순위(priority) , 순환할당(round-robin)
		dog.setPriority(10);
		cat.setPriority(Thread.MIN_PRIORITY);
		dog.start();
		cat.start();
		
		System.out.println(dog.getName()+" => "+dog.getPriority());
		System.out.println(cat.getName()+ " => "+cat.getPriority());
		
	}
}
