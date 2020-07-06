package com.test02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MTest {
	public static void main(String[] args) throws IOException{
		String fileName="a.jpg";
		
		/*
		 * FileInputStream fi = new FileInputSteam(fileName);
		 * BufferedInputStream bi = new BufferInputStream(fi);
		 */
		
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(fileName));
		FileOutputStream fo = new FileOutputStream(new File("c.jpg"));
		
		int a =0;
		while((a=bi.read())!=-1) {
			fo.write(a);
		}
		
		fo.close();	// 생성된 역순으로 close() 해준다
		bi.close();
	}
}
