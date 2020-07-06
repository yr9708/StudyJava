package com.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MTest04 {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress addr = 	InetAddress.getLocalHost();
		System.out.println(addr);
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		System.out.println();
		
		InetAddress[] google = InetAddress.getAllByName("www.google.com");
		for(int i=0; i<google.length; i++) {
			System.out.println(google[i].getHostName()+" "+google[i].getHostAddress());
		}
		
		
	}
}
