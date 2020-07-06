package com.baseball;

import java.util.Arrays;
import java.util.Scanner;

public class Game extends Print{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Referee referee = new Referee();
		User user = new User();
		int[] goal;
		int[] input;
		
		
		do {
			System.out.println(start);
			goal = new Ball().getGoal();
		//	System.out.println("[[["+Arrays.toString(goal)+"]]]");
			
			do {
				System.out.println(ingPre + (10-stage+1)+ingPost);
				input = user.input();
				int[] strike = referee.isStrike(goal, input);
				strikePrn(strike);
				
				if(strike[0]==3) {
					System.out.println(win);
					break;
				}
				
				stage--;
			}while(stage>0);
			
			if(stage==0) {
				System.out.println(losePre+Arrays.toString(goal)+losePost);
				
			}
			System.out.println(end);
			String stop = sc.next();
			if(stop.toUpperCase().equals("N")) {
				break;
			}
			
						
		}while(true) ;
		
		System.out.println(bye);
	
	}
}
