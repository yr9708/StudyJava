package com.test03;

public class SumX {

	/*
	 * 1. 다음과 같이 출력 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
	 * 25
	 * 
	 * 2. X모양의 숫자 합계를 출력하자
	 * 
	 */
	public static void main(String[] args) {

		int cnt = 0;
		int cntSum1 = 0;
		int cntSum2 = 0;

		for (int i = 1; i < 26; i++) {
			System.out.printf("%3d ", i);
			if (i % 5 == 0) {
				System.out.println();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cnt++;
				if (i == j) {
					cntSum1 += cnt;

				} else if (i + j == 4) {
					cntSum2 += cnt;

				}
			}
		}

		System.out.printf("X모양 숫자의 합은 %d 입니다.\n", cntSum1 + cntSum2);
		System.out.println("===============================");
		prn();

	}

	public static void prn() {
		int cnt = 1;
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				if (i == j || i + j == 4) {
					sum += cnt;
				}
				System.out.print(cnt++ + " ");
			}
			System.out.println();
		}

		System.out.println("X의 총 합 : " + sum);

	}

}
