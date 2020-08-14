package com.test07;

public class IgTV implements TV{

	public IgTV() {
		System.out.println("IgTV»ý¼º!");
	}
	
	@Override
	public void powerOn() {
		System.out.println("IgTv powerOn");
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("IgTv powerOff");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("IgTv volumeUp");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("IgTv volumeDown");
	}
	
}
