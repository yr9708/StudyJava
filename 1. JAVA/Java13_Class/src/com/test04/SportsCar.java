package com.test04;

public class SportsCar extends Car{
	
	/*
	 * 기본 생성자와 색깔 하나를 받아서 초기화하는 파라미터 1개짜리 생성자
	 * accelPedal과 breakPedal 메소드를 오버라이드 하는데 
	 * "속도가 더 빨리 올라갑니다"
	 * +15
	 * "속도가 더 빨리 줄어듭니다" 라고 출력
	 * -15
	 * 
	 * toString 오버라이드해서 
	 * "sportsCar의 현재 속도는 X 입니다"; 출력
	 * 
	 */
	
	public SportsCar() {
		
	}
	
	public SportsCar(String color) {
		super(color);
				
	}
	
	@Override
	public void accelPedal() {
		System.out.println("속도가 더 빨리 올라갑니다");
		int speed =super.getSpeed();
		super.setSpeed(speed+=15);
		
	}
	
	@Override
	public void breakPedal() {
		int speed =super.getSpeed();
		setSpeed(speed-15);
		if(getSpeed()>0) {
			System.out.println("속도가 더 빨리 줄어듭니다");
		}else {
			System.out.println("멈췄습니다.");
			super.setSpeed(0);
		}
	}
	
	public String toString() {
		return "sportsCar의 " + super.toString();
	}
	
}
