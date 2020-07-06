package com.test01;

import java.util.Arrays;

public class MTest02 {
	public static void main(String[] args) {
		
		// 방법 1
		int[][] a= new int[3][2];			// 2차원 배열
		a[0][0]=1;
		a[0][1]=2;
		a[1][0]=3;
		a[1][1]=4;
		a[2][0]=5;
		a[2][1]=6;
		
		
		// 방법 2  :  특별히 배열안에 값을 넣지 않으면 기본 0 으로 채워진다.
		int[][] b= new int[3][];
		b[0]=new int[3];
		b[1]=new int[5];
		b[2]=new int[1];
		
		// 방법 3
		int[][] c=new int[][] {
			{1,2},		
			{3,4,5},
			{6,7,8,9},
			{0}			
		};
		
	
		// 방법 4
		int[][] d= {{1}, {2,3,4,5}, {6,7}, {8}};
		
		
		System.out.println(a[2][0]);
		// c:9 + d:4
		System.out.println(c[2][3]+d[1][2]);
		prn(c);
		prn(d);
		
		String [][] s = {
				{"have", "a","nice","day"},
				{"너무","어려워"},
				{"배열","2차원 배열"}
		};
		modi(s);
	}
	
	public static void prn(int[][] arr) {
		// 전체출력
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%d ",arr[i][j]);
			}
			System.out.println();
		}
		
		
	//	System.out.println(Arrays.deepToString(arr));
	
	}
	
	public static void modi(String[][] a) {
		// nice -> good
		a[0][2]="good";
		// 어려워 -> 쉬워
		a[1][1]="쉬워";
		// 전체 출력
		
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
