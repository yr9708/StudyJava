package com.test01;

import java.io.*;


public class Mtest03 {
	public static void main(String[] args) throws IOException {
		File fi = new File("a.txt");
		try {
			myInput(fi);
			myOutput(fi);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void myInput(File fi) throws IOException{
		FileReader fr = new FileReader(fi);
		int ch;
		
		
		
		
		
		// 처음부터 파일의 끝까지, 한 글자씩 읽어서 가져오자.
		while((ch=fr.read()) != -1) {
			System.out.println((char)ch+" : "+ch); // 만약 비어있다면 -1 을 리턴
/* -1 리턴 되는 거 보고 싶어서...*/
//		int c = 1;
//		while(c==1) {
//			System.out.println(fr.read());
//			break;
//		}
			
		}
		fr.close();
	}
	
	
	
	private static void myOutput(File fi) throws IOException{
		FileWriter fw = new FileWriter(fi,true);
		fw.write("연습중입니다.\n");
		fw.append("abc\n").append("def\n");
		fw.close();
	}
}

