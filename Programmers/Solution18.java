package Programmers1;

import java.util.Arrays;


/*
 * 자연수 뒤집어 배열로 만들기
 */

public class Solution18 {
	public static void main(String[] args) {
		System.out.println(solution(12345));
	}
	
	public static int[] solution(long n) {
        String s = String.valueOf(n);
        
        int[] answer = new int[s.length()];
        int j = s.length()-1;
        for(int i=0; i<s.length(); i++) {
        	answer[j] =  s.charAt(i) -48;
        	j--;
        }
       
        System.out.println(Arrays.toString(answer));
        
        
        
        
        return answer;
    }
}
