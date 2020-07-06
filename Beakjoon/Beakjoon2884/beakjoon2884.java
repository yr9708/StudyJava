package beakjoon;

import java.util.Scanner;

public class beakjoon2884 {

	public static void main(String[] args) {
		/*
		 * 문제 45분 일찍 알람 설정하기
		 * 
		 * 입력 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 알람 시간 H시 M분을 의미 입력 시간은 24시간 표현을
		 * 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다. 시간을 나타낼 때, 불필요한
		 * 0은 사용하지 않는다.
		 * 
		 * 
		 * 
		 * 
		 * 12:00 받으면 11:15분
		 * 
		 * 분이 45분과 같거다 크면 -45 But 00이라면 60-45 분이 45분과 작다면 뒤에 minute+15분 hour 에서 -1 빼고
		 * 60-45분
		 * 
		 * 12:30 받으면 11:45분
		 * 
		 * 
		 * 11:10 받으면 10시25분 if (hour>minute) 11:11 받으면 ???
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		int i = 0;
		int minute = 0;
		int hour = 0;

		/*
		 * boolean hourOk = (0 <= hour && hour <= 23); boolean minuteOk = (0 <= minute
		 * && minute <= 59);
		 */
		while (true) {

			System.out.println("0~23사이의 시간을 입력하세요");
			hour = sc.nextInt();

			if (0 <= hour && hour <= 23) {
				System.out.println("0~59사이의 분을 입력하세요");
				minute = sc.nextInt();
			} else {
				System.out.println("잘못 입력하셨습니다.");
				break;

			}

			if (0 <= minute && minute <= 59) {
				minute = minute;
			} else {
				System.out.println("잘못 입력하셨습니다");
				break;
			}
			sc.close();
			System.out.printf("%d시 %d분 입력되었습니다.\n", hour, minute);

			if (minute >= 45) {
				minute = minute - 45;
			} else if (minute == 00) {
				minute = 60 - 45;
				if (hour == 0) {
					hour = 23;
				}
				hour = hour - 1;
			} else {
				minute = minute + 15;
				if (hour == 0) {
					hour = 23;
				}
				hour = hour - 1;

			}
			System.out.printf("%d시 %d분 알람이 설정되었습니다.", hour, minute);
			break;

		}

	}

}
