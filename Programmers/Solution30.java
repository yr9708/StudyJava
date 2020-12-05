package Programmers1;

import java.util.Arrays;

/*
 * 행렬의 덧셈
 */
public class Solution30 {
	public static void main(String[] args) {
		int[][]arr1 = {{1},{2}};
		int[][]arr2 = {{3},{4}};
		solution(arr1,arr2);
	}
	
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        
        for(int i=0; i<arr1.length; i++) {
        	for(int j=0; j<arr1[i].length; j++) {
        		System.out.println(arr1[i][j]);
        		answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        }
        
        System.out.println(Arrays.deepToString(answer));
        
        return answer;
    }
}
