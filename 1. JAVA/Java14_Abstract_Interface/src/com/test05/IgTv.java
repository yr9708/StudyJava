package com.test05;

public class IgTv implements TV {

	private int volume;
	
	public IgTv() {
		System.out.println("IgTv 구매완료");
	}
	
	@Override
	public int volumeUp() {
		
		return this.volume+=1; // ++volume
	}

	@Override
	public int volumeDown() {
		if(volume>0) {
			return volume-=1;	// (--volume>=)? volume : 0;
		}else{
			return volume=0;
		}
	}

}
