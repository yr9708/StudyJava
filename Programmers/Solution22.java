package Programmers1;

/*
 * 자릿수 더하기
 */
public class Solution22 {
	public static void main(String[] args) {
		solution(987);
	}    
	
	public static int solution(int n) {
        int answer = 0;
        
        String str = String.valueOf(n);
        
        for(int i=0; i<str.length(); i++) {
        	answer += Character.getNumericValue(str.charAt(i));
        }
        
        System.out.println(answer);
        
        
        return answer;
    }
}
