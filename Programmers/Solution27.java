package Programmers1;

/*
 * 콜라츠 추측
 */
public class Solution27 {
	public static void main(String[] args) {
		solution(1);
	}
	
    public static int solution(int num) {
        int answer = 0;
        long a = num;
        
        if(a==1) {
        	return 0;
        }
        
        while(true) {
        	System.out.println(a);
        	if(a%2==0) {
        		a = a/2;
        	}else {
        		a = a*3 +1;
        	}
        	answer++;
        	
        	if(answer==500) {
        		answer = -1;
        		break;
        	}
        	
        	if(a==1) {
        		break;
        	}
        	
        }
        
        System.out.println(answer);
        return answer;
    }
}
