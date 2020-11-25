package Programmers1;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * 
 * 나누어 떨어지는 숫자 배열
 */
public class Solution11 {
	public static void main(String[] args) {
		int[] arr = {3,2,6};
		solution2(arr,10);
	}
	// 리턴타입을 바꿔서 쉽게 풀기
	public static ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt=0;
        
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]%divisor==0) {
        		answer.add(arr[i]);
        		cnt++;
        	}
        }
        
        if(cnt==0) {
        	answer.add(-1);
        }
        
        answer.sort(null);
        
        return answer;
    }
	
	// 람다를 이용한 풀이
	public static int[] solution2(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(factor -> factor%divisor==0).toArray();
		if(answer.length ==0) {
			answer = new int[] {-1};			
		}
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
