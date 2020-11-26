package Programmers1;
/*
 * 문자열을 정수로 바꾸기
 */
public class Solution12 {
	public static void main(String[] args) {
		solution("-1234");
	}
	
	public static int solution(String s) {
        int answer = 0;
        answer = Integer.parseInt(s);
        System.out.println(answer);
        
        return answer;
    }
}
