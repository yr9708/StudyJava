package com.test04;

public class Truck extends Car{
	/*
	 * 기본 생성자와 색깔 하나를 받아서 초기화하는 파라미터 1개짜리 생성자
	 * accelPedal과 breakPedal 메소드를 오버라이드 하는데 
	 * "속도가 더 천천히 올라갑니다"
	 * +5
	 * "속도가 더 천천히 줄어듭니다" 라고 출력
	 * -5
	 * 
	 * toString 오버라이드해서 
	 * "Truck의 현재 속도는 X 입니다"; 출력
	 * 
	 */

	
	public Truck() {
	}
	
	public Truck(String color) {
		//setColor(color);
		super(color);
	}
	
	@Override
	public void accelPedal() {
		System.out.println("속도가 더 천천히 올라갑니다");
		// speed +=5;
		// speed = speed +5;
		// setter(getter+5);
		// setSpeed(getSpeed()+5)
		int speed =super.getSpeed();
		super.setSpeed(speed +5);
	}
	
	@Override
	public void breakPedal() {
		// setSpeed(getSpeed()-5);

		super.setSpeed(getSpeed()-5);
		
		if(getSpeed()>0) {
			System.out.println("속도가 더 천천히 줄어듭니다");
		}else {
			System.out.println("멈췄습니다.");
			setSpeed(0);
		}
	}
	
//	public String toString() {
//		int speed =super.getSpeed();
//		return "트럭의 현재 속도는 "+speed+" 입니다";
//	}
	
	
	
	public String toString() {
		return "truck의 " + super.toString();
	}
	
}
