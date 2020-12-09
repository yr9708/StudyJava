package Programmers2;

import java.util.Arrays;

/*
 * 행렬의 곱셈
 */
public class Solution1 {
	public static void main(String[] args) {
		int[][] arr1 = {{1,2,3},{4,5,6}};
		int[][] arr2 = {{1,4},{2,5},{3,6}};
		solution(arr1,arr2);
	}
	
	// 앞에 있는 행렬의 열의 갯수 m * k
	// 뒤에 있는 행렬의 행의 갯수 k * n
	
	//그래서 결과는 앞에 행렬의 행 + 뒤의 행렬의 열이 된다 m * n -> k가 같기때문에
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        System.out.println(arr1.length);
        System.out.println(arr1[0].length);
        System.out.println(arr2.length);
        System.out.println(arr2[0].length);
        
        int cnt = 0;
        for(int i=0; i<arr1.length; i++) {
        	for(int k=0; k<arr2[0].length; k++) {
        		for(int j=0; j<arr2.length; j++) {
	        		cnt += arr1[i][j] * arr2[j][k];
        		}
        		answer[i][k] = cnt;
        		cnt = 0;
        	}
        	
        }
        
        System.out.println(Arrays.deepToString(answer));
        
        
        
        return answer;
    }
}
