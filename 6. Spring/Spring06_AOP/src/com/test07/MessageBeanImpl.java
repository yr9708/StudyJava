package com.test07;

public class MessageBeanImpl implements MessageBean {
	
	private String name;
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Override
	public void sayHello() {
		try {
			Thread.sleep(2000); // 2초동안 잠깐 멈출거야(지연시킬거야)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hello, " + name);

	}

}
