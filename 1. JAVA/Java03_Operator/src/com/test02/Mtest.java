package com.test02;

public class Mtest {

	public static void main(String[] args) {
		/*
		 * 1. 다음 class diagram을 보고 class를 작성하자.
		 * 
		 * 2. basketSetting 메서드에서는 String name과 int fruit라는 parameter가 있는데,
		 * 		name의 값을 전역변수 fruitName에 대입하고
		 * 		fruit의 값을 fruitCount에 대입하자.
		 * 
		 * 그 후 basketPrn() 메서드를 호출하자.
		 * 
		 * 3. basketPrn 에서는
		 * 		"바구니 안의 과일 : xx " (과일의 이름)을 출력하고,
		 * 		basketSize의 값이 fruitCount 값보다 더 크거나 같으면,
		 * 		"xx의 갯수는 n개 입니다." (과일의 이름, 과일의 숫자)
		 * 		작으면
		 * 		"바구니가 넘쳤습니다."
		 * 		를 출력하자.
		 * 
		 * 		삼항연산자를 사용하자!
		 */
		FruitBasket.basketSize=20;
		FruitBasket bananaBasket = new FruitBasket();
		bananaBasket.basketSetting("바나나", 10);
		System.out.println(bananaBasket.basketSize); // Static 이기 때문에 전체 필드 적용
		System.out.println(bananaBasket.fruitCount); // nonStatic 이기 때문에 바나나에만 적용
		
		FruitBasket.basketSize=40;
		FruitBasket appleBasket = new FruitBasket();
		appleBasket.basketSetting("사과",20);
		System.out.println(appleBasket.basketSize);
		System.out.println(appleBasket.fruitCount);
		
		System.out.println(bananaBasket.basketSize);
		
	}
	

}
