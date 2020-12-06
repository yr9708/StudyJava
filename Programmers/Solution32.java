package Programmers1;

import java.util.Arrays;

/*
 * x만큼 간격이 있는 n의 숫자
 */
public class Solution32 {
	public static void main(String[] args) {
		solution(-4,2);
	}
	
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long y = (long)x;
        
        for(int i=0; i<n; i++) {
        	answer[i] = y + (y*i);
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}
