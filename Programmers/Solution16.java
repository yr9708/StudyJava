package Programmers1;

import java.util.Arrays;

/*
 * 체육복
 */
public class Solution16 {
	
	public static void main(String[] args) {
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.println(solution(5,lost,reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 전체 학생 수 n
        // 체육복 안가져온 애 lost
        // 여벌옷 reserve

        // ex) lost ={1,2,4} reserve={1,3,4}
        // 일때 1,4는 진짜 수업 못듣는 애들이니까 그 유효성 검사해주는 것.
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<reserve.length; j++) {
        		if(lost[i] == reserve[j]) {
        			reserve[j] = -1;
        			lost[i] = -1;
        		}
        	}
        }
        
       for(int i=0; i<lost.length; i++) {
    	   if(lost[i]!=-1) {
    		   n--;
    	   }
       }
       
        System.out.println(Arrays.toString(reserve));
        System.out.println(Arrays.toString(lost));
        
        for(int i=0; i<reserve.length; i++) {
        	int cnt = reserve[i];
        	for(int j=0; j<lost.length; j++) {
        		if(lost[j]==cnt+1 || lost[j]==cnt-1) {
        			n++;
        			lost[j] = -1;
        			j = lost.length;
        		}
        	}
        }
        
        answer = n;
        
        return answer;
    }
}
