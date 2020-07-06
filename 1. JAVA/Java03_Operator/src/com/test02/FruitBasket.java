package com.test02;

public class FruitBasket {
	public static int basketSize; // class 변수
	int fruitCount;						// instance 변수
	String fruitName;
	
	public void basketSetting(String name, int fruit) {
		 fruitName = name;
		 fruitCount = fruit;
		basketPrn();
		
	}
	
	private void basketPrn() {
		System.out.printf("바구니 안의 과일 : %s\n",fruitName);
		String str = basketSize >= fruitCount ? fruitName+"의 갯수는 "+fruitCount+"개 입니다." : "바구니가 넘쳤습니다." ;
		System.out.println(str);

		
			
	}
}
