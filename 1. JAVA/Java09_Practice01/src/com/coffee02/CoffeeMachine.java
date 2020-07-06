package com.coffee02;

import java.util.Scanner;

public class CoffeeMachine {
	public void inputMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("돈을 넣어주세요");
		int money = sc.nextInt();
		System.out.println("몇잔 만들까요? (1잔당 300원)");
		int cnt = sc.nextInt();
		
		if(money >= (300*cnt)) {
			make(money, cnt);
		}else {
			System.out.println("돈이 부족합니다.");
		}
		
		
	}
	public void make(int money, int cnt) {

		int change = money%(300*cnt);
		System.out.printf("커피 %d잔 나왔습니다.\n잔돈은 %d원 입니다.",cnt,change);
	}
}
