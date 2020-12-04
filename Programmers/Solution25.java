package Programmers1;

/*
 * 시저 암호
 */
public class Solution25 {
	public static void main(String[] args) {
		solution("a B z",24);
	}
	
	public static String solution(String s, int n) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
        	if(arr[i]==' ') {
        		arr[i]=' ';
        	}else {        		
        		if(97<=arr[i] && arr[i]<123) {
        			// 소문자라면
        			if(arr[i]+n>122) {
        				int cnt = (arr[i]+n) -123;
        				arr[i] = (char) (97 + cnt);
        			}else {
        				arr[i] = (char) (arr[i]+n);
        			}
        		}else if(65<=arr[i] && arr[i]<91) {
        			// 대문자라면
        			if(arr[i]+n>90) {
        				int cnt = (arr[i]+n) - 91;
        				arr[i] = (char) (65 + cnt);
        			}else {
        				arr[i] = (char) (arr[i]+n);
        			}
        		}
        	}
        	answer += arr[i];
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
