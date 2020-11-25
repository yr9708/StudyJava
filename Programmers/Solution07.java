package Programmers1;
/*
 * 가운데 글자 가져오기
 */
public class Solution07 {
	public static void main(String[] args) {
		solution("qwer");
		solution("abcde");
	}
	
	public static String solution(String s) {
        String answer = "";
        
        char[] chr = new char[s.length()];
        for(int i =0; i<s.length(); i++) {
        	chr[i] = s.charAt(i);
        }
        
        int index=0;
        if(s.length() %2 ==0) {
        	index = (s.length()/2) -1;
        	answer = chr[index] +""+ chr[index+1];
        }else {
        	index = (s.length()/2);
        	answer = new Character(chr[index]).toString();        	
        }

        return answer;
    }
}
