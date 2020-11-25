package Programmers1;
/*
 * 서울에서 김서방 찾기
 */
public class Solution08 {
	public static void main(String[] args) {
		String [] seoul = {"Jane","Kim"};
		solution(seoul);
	}
	public static String solution(String[] seoul) {
        String answer = "";
        
        for(int i=0; i<seoul.length; i++) {
        	if(seoul[i].equals("Kim")) {
        		answer="김서방은 "+i+"에 있다";
        		break;
        	}
        }

        System.out.println(answer);
        return answer;
    }
}
