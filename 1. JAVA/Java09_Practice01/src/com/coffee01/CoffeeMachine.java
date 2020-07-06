package com.coffee01;

import java.util.Scanner;

public class CoffeeMachine {

	public void inputMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("돈을 넣어주세요(1잔당 300원)");
		int money = sc.nextInt();
		
		if(money > 300) {
			make(money);
		}else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
	private void make(int money) {
		int coffee = money/300; //커피잔 수
		int change = money%300; //잔돈
		System.out.printf("커피 %d잔 나왔습니다. \n잔돈은 %d원 입니다.\n",coffee,change);
		
	}
	
	
}
