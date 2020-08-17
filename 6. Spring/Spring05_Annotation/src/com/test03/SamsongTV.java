package com.test03;

import org.springframework.stereotype.Component;

@Component("samsong")
public class SamsongTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamgsongTV powerOn");

	}

	@Override
	public void powerOff() {
		System.out.println("SamgsongTV powerOff");

	}

	@Override
	public void volumnUp() {
		System.out.println("SamgsongTV volumnUp");

	}

	@Override
	public void volumnDown() {
		System.out.println("SamgsongTV volumnDown");

	}

}
