package com.test01;

import java.io.File;

public class MTest02 {
	public static void main(String[] args) {
		File fi = new File("D:\\");
		printFiles(fi);
	}
	
	
	public static void printFiles(File fi) {
		// 파일 목록과 폴더 목록을 구분해서 출력하자
		// 파일 갯수와 폴더의 갯수를 출력하자
		int fileCnt = 0;
		int dirCnt = 0;

		for (File f : fi.listFiles()) {
			if (f.isFile()) {
				fileCnt++;
				System.out.println("file : " + f);
			} else if (f.isDirectory()) {
				dirCnt++;
				System.out.println("dir : " + f);
			}
		}
		System.out.println("file의 갯수 : "+fileCnt);
		System.out.println("dir의 갯수 : "+dirCnt);
	}
}
