package Programmers1;
/*
 * 수박수박수박수박수?
 */
public class Solution13 {
	public static void main(String[] args) {
		solution(4);
	}
	
	public static String solution(int n) {
        String answer = "";
        for(int i=0; i<n; i++) {
//        	if(i%2==0) {
//        		answer += "수";
//        	}else {
//        		answer += "박";
//        	}
//        	
        	answer += i%2 ==0 ? "수":"박";
        }
        
        System.out.println(answer);
        return answer;
    }
	
}
