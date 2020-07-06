package com.gawibawiibo;

import java.util.Scanner;

public class Player extends GawiBawiBo{
	
	public void setSelect() {
		System.out.println("input Select\n0:Gawi 1:Bawi 2:Bo");
		Scanner sc = new Scanner(System.in);
		int select= sc.nextInt();
		super.setSelect(select);
		
	}
	
	
	
	
	
	
	
}
