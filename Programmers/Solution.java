package Programmers1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solution(118372));
		
	}
	
	public static long solution(long n) {
		String str = n+"";
		int tmp;
		Integer [] arry = new Integer[str.length()];
		for(int i=0; i<str.length(); i++) {
			arry[i] = (int)(n%10);
			n = n/10;
		}

		Arrays.sort(arry, Collections.reverseOrder());
		String result = "";
		
		for(int i=0; i<arry.length; i++) {
			result += arry[i];
		}
		
		long answer = 0;
		
		answer = Long.parseLong(result);
		
        return answer;
	}
}
