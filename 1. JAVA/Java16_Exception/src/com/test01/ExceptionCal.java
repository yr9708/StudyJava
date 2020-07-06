package com.test01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCal {
	public int calculation() {
		int res = 0;
	
		while (true) {
			try {
				res = inputNum() / inputNum();
				break;
			} catch (InputMismatchException e) {
				// e.printStackTrace();
				System.out.println("You should input only number.");
				System.out.println("please input again");
			}catch(ArithmeticException e) {
				System.out.println("Don't division ZERO");
				System.out.println("please input again");
			}finally {
				System.out.println("----------------------------");
			}
		}
		return res;
	}
	
	
	
	private int inputNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("input Number");
		int n = sc.nextInt();
		return n;
	}
}
