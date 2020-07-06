package com.test01;

import java.io.*;

public class MTest05 {
	public static void main(String[] args) throws IOException{
		File file = new File("b.txt");
		myOutput(file);
		myInput(file);
	}
	// 입력
	private static void myOutput(File file)throws IOException{
		FileOutputStream fo = new FileOutputStream(file);
		for(int i =65; i<=90; i++) {
			fo.write(i);
		}
		fo.close();
	}
	// 출력
	private static void myInput(File file)throws IOException{
		FileInputStream fin = new FileInputStream(file);
		
		int res= 0;
		while((res=fin.read())!= -1) {
			System.out.print((char)res);
		}
		fin.close();
	}
}
