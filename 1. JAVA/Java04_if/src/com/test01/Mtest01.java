package com.test01;

public class Mtest01 {
	public static void main(String[] args) {

		prn01();
		prn02(false,false);
	}

	public static void prn01() {
		int i = 10;
		int j = 20;

		// if ~ else
		if (i < j) {
			System.out.println("i가 j보다 작습니다.");
		} else {
			System.out.println("i가 j보다 작거나 같습니다.");
		}

		// if ~ else if
		if (i > j) {
			System.out.println("i가 j보다 큽니다.");
		} else if (i < j) {
			System.out.println("i가 j보다 작습니다.");
		} else if (i == j) {
			System.out.println("i와 j는 같습니다.");
		}

		// if ~ else if ~ else
		if (i > j) {
			System.out.println("i가 j보다 큽니다.");
		} else if (i < j) {
			System.out.println("i가 j보다 작습니다.");
		} else {
			System.out.println("i와 j는 같습니다.");
		}
	}

	public static void prn02(boolean ring, boolean married) {

		if (ring) {
			if (married) {
				System.out.println("결혼하셨군요!");
			} else {
				System.out.println("연인이 있으시군요!");
			}
		}else {
			if(married) {
				System.out.println("결혼반지 어디..?");
			}else {
				System.out.println("솔로...?");
			}
		}
		
		if(ring && married) {
			System.out.println("결혼하셨군요!");
		}else if(ring || married) {
			System.out.println("연인이 있으시군요?");
		}else {
			System.out.println("빛이 나눈 솔로 따라랄따라라라라라라라");
		}

	}
}
