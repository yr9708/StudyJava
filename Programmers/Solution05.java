package Programmers1;
/*
 * k번째 수
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution05 {
	public static void main(String[] args) {
		int [] array = {1, 5, 2, 6, 3, 7, 4};
		int [][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		solution(array,commands);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        
        
        for(int i=0; i<commands.length; i++) {
        		
        		int a = commands[i][0] -1;
        		int b = commands[i][1] -1;
        		int c = commands[i][2] -1;
        		
        		
        		
        		for(int k=a; k<=b; k++) {
        			System.out.println("k :"+array[k]);
        			list.add(array[k]);
        		}
        		list.sort(null);
        		answer[i]=list.get(c);
        		list.removeAll(list);
        	
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}
