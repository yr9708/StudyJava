package Programmers1;

/*
 * 평균 구하기
 */
public class Solution28 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		solution(arr);
	}
	
    public static double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
        	sum += arr[i];
        	System.out.println(sum);
        }
        
        answer = sum/ (double)arr.length;
        
        System.out.println(answer);
        return answer;
    }
	
}
