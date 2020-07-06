package com.test03;

public class School {
	public static void main(String[] args) {
		String name = "여림짱";
		int kor = 100;
		int eng = 81;
		int math = 70;
		/*
		 * Score 클래스에 메서드를 만들자.
		 * 1. int(kor, eng, math) 3개 입력받아 
		 * 		평균을 리턴하는 getAvg 메서드를 만들자. 리턴타입  double
		 * 		어디서나 접근 가능하고, non-static이다.
		 * 
		 * 2. double avg (평균) 입력받아 
		 *	100 ~ 90 : A
		 * 89 ~ 80 : B
		 * 79 ~ 70 : C
		 * 69 ~ 60 : D
		 * 59 ~ : F
		 * 를 리턴하는 getGrade 메서드를 만들자.
		 * 어디서나 접근 가능하고, non-static이고, 리턴타입은 String
		 *
		 *
		 * 3. School 클래스의 main 메서드에서 
		 * 		Score 클래스의 getAvg 메서드를 사용하여 평균을 출력하고
		 * 		Score 클래스의 getGrade 메서드를 사용하여 등급을 출력하자.
		 * ex) 평균 : 60.11 (소수점 둘째자리까지 출력-> String class 사용)
		 * 		등급 : D
		 */
		
		
		Score s = new Score(); // non -Static 이기 때문에 객체 생성 후 진행

		System.out.println("평균 : "+ String.format("%.2f", s.getAvg(kor, eng, math)));
		System.out.println("등급 : "+(s.getGrade(s.getAvg(kor, eng, math))));
		

		
		
		
		
		
		
	}
}
