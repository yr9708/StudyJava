package com.coffee03;

import java.util.Scanner;

public class CoffeeMachine {
	public void inputMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("돈을 넣어주세요");
		int money = Integer.parseInt(sc.nextLine());
		System.out.println("어떤 커피를 만들어 드릴까요? (일반 300원, 고급 500원)");
		String coffee = sc.nextLine();
		System.out.println("몇잔 만들까요?");
		int cnt = Integer.parseInt(sc.nextLine());		


		if(coffee.equals("일반")) {
			if(money >= (300*cnt)) {
				make(money, cnt,coffee);
			}else {
				System.out.println("돈이 부족합니다.");
			}
		}else if(coffee.equals("고급")) {
			if(money >= (500*cnt)) {
				make(money, cnt,coffee);
			}else {
				System.out.println("돈이 부족합니다.");
			}
		}
		
		sc.close();
	}
	public void make(int money, int cnt, String coffee) {

		int coffeeValue=0;
		if(coffee.equals("일반")){
			coffeeValue=300;
		}else {
			coffeeValue=500;
		}
			
		int change = money%(coffeeValue*cnt);
		
		System.out.printf("%s커피 %d잔 나왔습니다.\n잔돈은 %d원 입니다.",coffee,cnt,change);
	}
}
