package com.test03;

import org.springframework.stereotype.Component;

@Component
public class IgTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("IgTV powerOn");

	}

	@Override
	public void powerOff() {
		System.out.println("IgTV powerOff");

	}

	@Override
	public void volumnUp() {
		System.out.println("IgTV volumnUp");

	}

	@Override
	public void volumnDown() {
		System.out.println("IgTV volumnDown");

	}

}
