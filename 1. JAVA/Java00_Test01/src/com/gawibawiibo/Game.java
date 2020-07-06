package com.gawibawiibo;

import java.util.Scanner;

public class Game {
	public static String isWin(int ai, int player) {
		
		/*
		 *    0	1	2 (player)
		 * 0 무
		 * 1		무
		 * 2			무
		 *
		 *(ai)
		 */
		
		String[][] winDrawLose= {
				{"draw","win","win"},
				{"lose","draw","win"},
				{"lose","lose","draw"}
		};
		
		
		return winDrawLose[ai][player];
	}
	
	
	public static void main(String[] args) {
		AI ai = new AI();
		Player player = new Player();
		System.out.println("GawiBawiBo Game");
		
		
		while(true) {
			ai.setSelect();
			player.setSelect();
			System.out.printf("Ai: %s VS Player: %s\n",ai.getHand(),player.getHand());
			System.out.println(isWin(ai.getSelect(),player.getSelect()));
			
			Scanner sc = new Scanner(System.in);
			System.out.println("The end? 0:End 1:continue");
			int end = sc.nextInt();
			if(end==0) {
				break;
			}
			
		}
		
	}
	
	
	
	
}
