package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class beakjoon2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i =0; i<arr.length; i++) {
			int a = sc.nextInt();
			arr[i]=a;
			sum+=arr[i];
		}
		Arrays.sort(arr);

		int x = 0;
		int y = 0;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if( sum - arr[i] - arr[j] == 100) {
					x = i;
					y = j;
					break;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i== x || i==y) { // 위에서 해당되는 인덱스라면 건너 뛰고 출력한다
				continue;
			}
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
}
