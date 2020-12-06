package Programmers1;

/*
 * 정수 제곱근 판별
 */
public class Solution33 {
	public static void main(String[] args) {
		solution(3);
	}
	
    public static long solution(long n) {
        long answer = 0;
        
        long i = 1 ;
        while(true) {
        	if(i * i == n) break;
        	i++;
        	if(i>n) return (long)-1;
        }
        
        answer = (i+1) * (i+1);
        
        System.out.println(answer);
        
        return answer;
    }
}
