package Programmers1;
/*
 * 2016년
 */

public class Solution14 {
	public static void main(String[] args) {
		solution(6,24);
	}
	
	public static String solution(int a, int b) {
        String answer = "";
        String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int total=0;
        for(int i=0; i<a-1; i++) {
        	total += days[i];
        }
        
        total += b-1;
        answer = week[(total+5)%7]; // 1월1일은 금요일이여서 +5 해줘야함

        System.out.println(answer);
        
        return answer;
    }
}
