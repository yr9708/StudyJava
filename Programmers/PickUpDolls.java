package Programmers1;

import java.util.ArrayList;
import java.util.List;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 */
public class PickUpDolls {
	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0},
						  {0,0,1,0,3},
						  {0,2,5,0,1},
						  {4,2,4,4,2},
						  {3,5,1,3,1}};
		
		int[] moves = {1,5,3,5,1,2,1,4};
		solution(board,moves);
	}
	
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
        List<Integer> pickup = new ArrayList<>();

        for(int move : moves) {
        	int index = move -1;
        	
        	for(int i=0; i<board.length; i++) {
        		if(board[i][index] != 0) {
        			pickup.add(board[i][index]);
        			board[i][index] = 0;
        			break;
        		}else {
        			continue;
        		}
        	}
        	
        }
        
        System.out.println(pickup);
        for(int i=0; i<pickup.size()-1; i++) {
    		if(pickup.get(i) == pickup.get(i+1)) {
    			answer++;
    			pickup.remove(i);
    			pickup.remove(i);
    			i = -1;
        	}
        }
        
        
        return answer*2;
	}
}
