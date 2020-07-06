package com.test05;

public class SamsongTV implements TV {
	private int volume;
	
	public SamsongTV() {
		System.out.println("SamsongTV 구매완료");
	}
	
	@Override
	public int volumeUp() {
		
		return volume+=3;
	}

	@Override
	public int volumeDown() {
		if (volume > 0) {
			return this.volume -= 3;
		} else {
			return volume = 0;
		}
	}

}
