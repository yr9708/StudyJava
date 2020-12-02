package Programmers1;

import java.util.Arrays;
import java.util.Collections;

/*
 * 문자열 내림차순으로 배치하기
 */
public class Solution20 {
	public static void main(String[] args) {
		solution("Zbcdefg");
	}
	public static String solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        
        for(int i=arr.length-1; i>=0; i--) {
        	answer += arr[i];
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
