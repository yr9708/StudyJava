package com.triangle;

import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("숫자를 입력해주라");
		int num=sc.nextInt();
		
		int [][] arr = new int [num][num];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j || i==i-j) {
					arr[i][j]=1;
				
				}else if(i>j){
					int a =arr[i-1][j-1];
					int b=arr[i-1][j];
					arr[i][j] = a+b;
				}
			}
		}
// 출력
		for(int i=0; i<arr.length; i++) {
			for(int k=0; k<num-i;k++) {
				System.out.print(" ");
			}
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==0) {
					System.out.print(" ");
				}else {
					System.out.print(arr[i][j]+" ");
				}
			}
				System.out.println();
		}
		
		
		
		
		
		
		
	}
}
