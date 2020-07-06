package com.test01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {
	public static void main(String[] args) throws Exception{
		// 클라이언트 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("클라이언트 입니다");
		
		// 보낼 data 생성
		byte[] buff = "연습입니다".getBytes();
		
		// packet으로 감싼다. 해당데이터, 데이터의 크기, 어떻게 연결할 것인지, 포트번호는 뭔지
		DatagramPacket sendPacket = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"),9999);
		
		// 보낸다
		ds.send(sendPacket);
		
		ds.close();
		ds.disconnect();
		
	}
}
