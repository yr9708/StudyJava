package Programmers1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 
 * 두 개 뽑아서 더하기
 */
public class Solution04 {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		int[] numbers2 = {5,0,2,7};
		/* solution(numbers); */
		solution(numbers2);
	}
	
	 public static int[] solution(int[] numbers) {
		 	List<Integer> list = new ArrayList<>();
		 	
	        
	        for(int i=0; i<numbers.length; i++) {
	        	for(int j=i+1; j<numbers.length; j++) {
	        		int sum = numbers[i] + numbers[j];
	        		if(list.indexOf(sum) < 0) { //  sum이라는 숫자가 list안에 존재하면 해당인덱스 리턴, 아님 -1리턴
	        			System.out.println(list.indexOf(sum));
	        			list.add(sum);
	        		}
	        		
	        	}
	        }
	        
	        int[] answer = new int[list.size()];
	        
	        for(int i=0; i<list.size(); i++) {
	        	answer[i] = list.get(i);
	        }
	        
	        Arrays.sort(answer);
	        
	        
	        System.out.println(Arrays.toString(answer));
	        


	        return answer;
	 }
}
