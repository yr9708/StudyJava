package com.compare;

import java.util.Arrays;

public class MTest {
	public static void main(String[] args) {
		Score a = new Score("이제훈",90,80,88);
		Score b = new Score("서강준",83,63,75);
	

		Score [] school = new Score[4];
		school[0]=a;
		school[1]=b;
		school[2]= new Score("김우빈",80,90,88);
		school[3]=new Score("공지철",100,100,100);
		
		for(Score score :school) {
			System.out.println(score);
		}
		System.out.println("-----------------------------");
		Arrays.sort(school);
		
		for(Score score :school) {
			System.out.println(score);
			System.out.println();
		}
		
		
		
		

	}
}
