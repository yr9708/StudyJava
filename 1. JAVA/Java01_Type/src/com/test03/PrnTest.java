package com.test03;

public class PrnTest {

	/*
	 * System.out.print() - 줄 바꿈 없음
	 * System.out.println() - 줄 바꿈 있음
	 * Sytem.out.printf() - 'f' : formatter (자리, 형식 지정)
	 * 
	 * java.util.Formatter
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.print("1. abc");
		System.out.println("2. def");
		int i = 100;
		System.out.printf("3.%10d %5d", i, i); // 형식과 자리를 만들어 줄 수 있다.
		
		/*
		 * 시험 점수 결과는 100(su)점이고 학점은 'A(ch)'가 나왔다.
		 * 나의 오늘 감정지수는 90.50(d)%이다.
		 * printf 하나만 사용하자.
		 * 
		 */
		
		int su = 100; // 10칸
		char ch = 'A'; // 5칸
		double d = 90.5; // 5칸 소수점 둘재자리까지 표시
		System.out.println();
		
		System.out.printf("시험 점수 결과는 %10d점 이고, 학점은 '%5c' 나왔다. %n 나의 오늘 감정 지수는 %5.2f%%이다.",su,ch,d);
		
	}

}
