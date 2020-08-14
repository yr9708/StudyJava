package com.test06;

public class IgTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("IgTv powerOn");
		
	}

	@Override
	public void pwoerOff() {
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
