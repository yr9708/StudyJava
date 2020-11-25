package Programmers1;
/*
 * 문자열 내 p와 y의 개수
 */
public class Solution09 {
	public static void main(String[] args) {
		System.out.println(solution("pPooyY"));
		}
	
	static boolean solution(String s) {
        boolean answer = true;
        int pcnt=0;
        int ycnt=0;
        
        for(int i =0; i<s.length(); i++) {
        	
        	
        	if(s.toUpperCase().charAt(i)=='P') {
        		pcnt++;
        	}
        	if(s.toUpperCase().charAt(i)=='Y') {
        		ycnt++;
        	}
        	
        	if(!s.toUpperCase().contains("Y") && !s.toUpperCase().contains("P")) {
        		return true;
        	}
        }

        if(ycnt==pcnt) {
        	return answer;
        }else {
        	return false;
        }
        
        
    }
}
