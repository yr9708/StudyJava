package com.test07;

public class Samsong implements TV {

	public Samsong() {
		System.out.println("SamsongTV»ý¼º!");
	}
	@Override
	public void powerOn() {
		System.out.println("samnsong tv powerOn");
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("samgsong tv powerOff");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("samsong tv volumeUp");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("samsong tv volumeDown");
	}

}
