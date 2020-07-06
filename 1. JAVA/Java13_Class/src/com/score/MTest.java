package com.score;

public class MTest {
	public static void main(String[] args) {
		Score Kang = new Score();
		Kang.setName("강여림");
		Kang.setKor(85);
		Kang.setEng(90);
		Kang.setMath(25);
		System.out.println(Kang);
		
		Score lee = new Score("이제훈", 50, 35, 100);
		System.out.println(lee);
	}
}
