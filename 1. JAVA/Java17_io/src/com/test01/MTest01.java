package com.test01;

import java.io.File;
import java.io.IOException;

public class MTest01 {
	public static void main(String[] args) {
		File file = new File("D:\\test_io");
	
		if(file.exists()) {
			System.out.println("exists...");
		}else {
			System.out.println("new!!");
			file.mkdir();
		}
		
		
		File file01 = new File(file,"AA");
		file01.mkdir();
		
		File file02 = new File("D:\\test_io","BB");
		file02.mkdir();
		
		File textFile = new File(file01, "a.txt");
		try {
			textFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("END");
		}
	}
}
