package com.test01;

import java.io.*;

public class MTest04 {
	public static void main(String[] args) {
		File file = new File("a.txt");
		myOutput(file);
		myInput(file);
	}
	
	private static void myOutput(File file) {
		// try with resources : try-catch가 종료되면 자동으로 종료됨
		
		try(FileWriter fw = new FileWriter(file)){
			fw.write("연습중입니다.\n");
			fw.append("가나다\\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
		//fw.close();
	}
	
	private static void myInput(File file) {
		try(FileReader fr = new FileReader(file)){
			int ch;
			while((ch=fr.read()) != -1) {
				System.out.println((char)ch);
			}
		}catch(FileNotFoundException e) {
			// 자동 생성시 한번에 catch문이 두개가 만들어짐
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
