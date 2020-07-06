package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class beakjooon1110 {
/*
 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 
 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 
 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.

26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 
새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.

위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.

N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input number");
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2];
		int sum=0;
		int newNum=0;
		int cnt =0;
		
		if(N<10) {
			arr[0]=0;
			arr[1]=N;
		}else {
			arr[0]=N/10;
			arr[1]=N%10;
		}
		
		while(true) {
			sum=arr[0]+arr[1]; 
			
			if(sum>=10) {
				sum=sum%10;
			}
			
			newNum=(arr[1]*10)+sum;
			
		
			if(newNum<10) {
				arr[0]=0;
				arr[1]=newNum;
			}else {
				arr[0]=newNum/10;
				arr[1]=newNum%10;
			}

			cnt++;
			if(newNum==N) {
				System.out.println("사이클 : "+cnt);
				break;
			}
		}		
		
		
		/*다른 사람 코드 */
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int cnt=0;
//		int sum;
//		int ini=N; // 첫 시작숫자
//		
//		while(true) {
//			int A=N/10;
//			int B=N%10;
//			sum=(A+B)%10;
//			N=B*10+sum;
//			cnt++;
//			
//			if(ini==N) {
//				break;
//			}
//		}
//		
//		System.out.println(cnt);
		
	}
	
}


