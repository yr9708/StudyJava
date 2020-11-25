package Programmers1;
/*
 * 문자열 다루기 기본
 */
public class Solution10 {
	public static void main(String[] args) {
		System.out.println(solution("12346"));
		
	}
	
	 static public boolean solution(String s) {
	    boolean answer = true;
	    
	    if(s.length()==4 || s.length()==6) {	    	
	    	for(int i=0; i<s.length(); i++) {
	    		if(s.charAt(i) <48 || s.charAt(i)>58) {
	    			return false;
	    		}
	    	}
	    }else {
	    	return false;
	    }
	    
	    
	    return answer;
	}
}
