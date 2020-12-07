package Programmers1;

import java.util.regex.Pattern;

/*
 * 핸드폰 번호 가리기
 */
public class Solution34 {
	public static void main(String[] args) {
		solution("027778888");
	}
	
    public static String solution(String phone_number) {
        String answer = "";
        char[]arr = phone_number.toCharArray();
        for(int i=0; i<arr.length-4; i++) {
//        	phone_number.replace("^[0-9]*$", "*"); 
        	arr[i] = '*';
        }
        
        for(char c : arr) {
        	answer += c;
        }
        
        
       // 정규식으로 * 만들기
       // return phone_number.replaceAll(".(?=.{4})", "*");
        System.out.println(phone_number.replaceAll(".(?=.{4})", "*"));
        // . 임의의 한 문자
        // () 소괄호 안의 문자를 하나의 문자로 인식
        // ? 앞 문자가 없거나 하나 있음
        // {} 횟수 또는 범위를 나타낸다.
        
        // 최소 4자리 문자열이 남도록
       
       System.out.println(answer);
        
        return answer;
    }
}
