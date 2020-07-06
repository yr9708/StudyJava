package com.baseball;

public class Referee {
	
	/*int[] output;
	 * output[0] = strike;
	 * output[1] = ball;
	 * output[2] = out;
	 * 
	 */
	
	public int[] isStrike(int[] goal, int[] input) {
		int[ ] output = new int[3];
		
		int strikeCount=0;
		int ballCount=0;
		
		for(int i=0; i<goal.length; i++) {
			for(int j=0; j<input.length; j++) {
				if(goal[i]==input[j]) {
					if(i==j) {
						strikeCount++;
					}else {
						ballCount++;
					}
				}
			}
		}
		
		
		if((strikeCount+ballCount)==0) {
			// out
			output[2]=1;
		}else {
			output[0]=strikeCount;
			output[1]=ballCount;
		}
		
		return output;
	}
}
