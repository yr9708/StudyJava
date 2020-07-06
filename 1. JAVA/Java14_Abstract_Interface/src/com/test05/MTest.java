package com.test05;

public class MTest {
	public static void main(String[] args) {
		TV ig = new IgTv();
		ig.volumeUp();
		ig.volumeUp();
		ig.volumeUp();
		ig.volumeUp();
		System.out.println(ig.volumeUp());
		
		ig.volumeDown();
		ig.volumeDown();
		ig.volumeDown();
		ig.volumeDown();
		ig.volumeDown();
		ig.volumeDown();
		System.out.println(ig.volumeDown());
		
		TV sstv = new SamsongTV();
		sstv.volumeUp();
		sstv.volumeUp();
		System.out.println(sstv.volumeUp());
		
		sstv.volumeDown();
		sstv.volumeDown();
		sstv.volumeDown();
		sstv.volumeDown();
		sstv.volumeDown();
		System.out.println(sstv.volumeDown());
		
	}
}
