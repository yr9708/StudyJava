package Programmers1;

/*
 * 하샤드 수
 */
public class Solution29 {
	public static void main(String[] args) {
		solution(11);
	}
	
    public static boolean solution(int x) {
        boolean answer = true;
        
        int harshad = x;
        int sum = 0;
        while(true) {
        	System.out.println(x);
        	sum += x%10;
        	x = x/10;
        	
        	if(x<=0) break;
        }
        
        answer = harshad%sum==0 ? true : false;
        
        System.out.println(answer);
        return answer;
    }
}
