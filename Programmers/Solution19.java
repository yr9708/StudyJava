package Programmers1;


/*
 * 이상한 문자 만들기
 */
public class Solution19 {
	public static void main(String[] args) {
		solution("try hello world ");
	}
	
	public static String solution(String s) {
        String answer = "";
        
        
        int i = 0;
        for(String str : s.split("")) {
        	i++;
        }
        String[] arr = new String[i]; //
        
        
        int j = 0;
        for(String str : s.split("")) {
        	arr[j] = str;

        		System.out.println(arr[j]+" "+j);
        		if(arr[j].equals(" ")) {
        			answer += " ";
        			j = 0;
        		}else {        			
        			if(j%2==0) {
        				answer += arr[j].toUpperCase();
        				j++;
        			}else {
        				answer += arr[j].toLowerCase();
        				j++;
        			}
        		}
        	}

        	
        	
        
        
        
//        String str[] = s.split("");
//        int a = 0 ;
//        for(int i=0; i<str.length; i++) {
//        	if(str[i].equals(" ")) {
//        		a = 0;
//        		answer += " ";
//        	}else {
//        		if(a%2==0) {
//        			a++;
//        			answer += str[i].toUpperCase();
//        		}else {
//        			a++;
//        			answer += str[i].toLowerCase();
//        		}
//        	}
//        }
        
        
        
        
        
        
        
        
        
        
       
        if(!s.equalsIgnoreCase(answer)) {        	
        	
        	System.out.println(s);
        	System.out.println(answer);
        	
        }else {
        	System.out.println(s);
        	System.out.println(answer);
        	System.out.println("완전똑같애");
        }
        
        
        return answer;
	}
}
