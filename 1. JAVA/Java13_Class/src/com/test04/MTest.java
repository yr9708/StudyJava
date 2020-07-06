package com.test04;

public class MTest {
	public static void main(String[] args) {
		Car sportsCar = new SportsCar();
		sportsCar.accelPedal();
		sportsCar.accelPedal();
		System.out.println(sportsCar);
		sportsCar.breakPedal();
		sportsCar.breakPedal();
		sportsCar.breakPedal();
		System.out.println(sportsCar);
		
		Car truck = new Truck("파란색");
		truck.accelPedal();
		truck.accelPedal();
		System.out.println(truck);
		truck.breakPedal();
		truck.breakPedal();
		truck.breakPedal();
		System.out.println(truck);
		// System.out.println(truck.toString());
		
		
		
		
		
		
	}
}
