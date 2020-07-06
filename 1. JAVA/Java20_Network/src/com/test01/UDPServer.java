package com.test01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		// 서버 생성
		
		DatagramSocket ds = new DatagramSocket(9999);
		System.out.println("서버입니다");
		
		// data를 받아줄 공간
		byte[] buff = new byte[1024];
		
		// packet을 받을 준비
		DatagramPacket receivePacket = new DatagramPacket(buff, buff.length);
		
		// 받는다
		ds.receive(receivePacket);
		System.out.println(new String(receivePacket.getData()));
		
		ds.close();
		ds.disconnect();
		
	}
}
