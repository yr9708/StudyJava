package Programmers1;

import java.util.Arrays;

/*
 * 최대공약수와 최소공배수
 */
public class Solution36 {
	public static void main(String[] args) {
		solution(200,100);
	}
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
//        int cnt2 = 0;
//        int cnt3 = 0;
       
//        
//        while(true) {
//        	if(n%2==0 && m%2==0) {
//        		n = n/2;
//        		m = m/2;
//        		cnt2++;
//        	}else if(n%3==0 && m%3==0) {
//        		n = n/3;
//        		m = m/3;
//        		cnt3++;
//        	}else {
//        		break;
//        	}
//        }
        
        if(n==0 || m==0) {
        	answer[0]=1;
        	answer[1]=0;
        	return answer;
        }else if(n==0 && m==0) {
        	answer[0] = 0;
        	answer[1] = 0;
        	return answer;
        }
        
        int i = 2;
        int result = 1;
        while(true) {
        	System.out.println("i :"+i);
        	if(n%i==0 && m%i==0) {
        		n = n/i;
        		m = m/i;
        		result *= i;
        		System.out.println("result : "+result);
        		i = 1;
        	}
        	
        	if(i>n+m || i>1000000) {
        		break;
        	}
        		
        	i++;
        }
        
        answer[0] = result;
        answer[1] = result * n * m;
        
        System.out.println(Arrays.toString(answer));
        
//        answer[0]= (int)(Math.pow(2, cnt2) * Math.pow(3, cnt3));
//        answer[1] =(int)(Math.pow(2, cnt2) * Math.pow(3, cnt3) * n * m);
        return answer;
    }
}
