package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		
		// 서버
		ServerSocket serverSocket = null;
		// 클라이언트
		Socket serviceSocket;
		// 출력 객체 (서버out->클라이언트in)
		PrintWriter out = null;
		// 클라이언트에게 data 받을 객체
		BufferedReader in = null;

		try {
			serverSocket = new ServerSocket(7777);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			System.out.println("[server] client를 기다립니다");
			try {

				serviceSocket = serverSocket.accept();
				System.out.println("[server] client가 접속했습니다.");

				// 클라이언트에게 받을 객체
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
				
				// 클라이언트에게 보낼 객체
				out = new PrintWriter(serviceSocket.getOutputStream(), true); // autoFlush = true 데이터가 들어오고 비워주는 것을 자동으로 해주겠다.
				
				String inputLine;
				while((inputLine = in.readLine()) != null) { // 클라이언트가 보낸 data를 한줄씩 읽어서 inputLine에 넣고, null이 되기 전까지 계속 진행
					System.out.println("[server] client가 보낸 메세지 : "+inputLine);
					out.println("*"+inputLine); // 클라이언트에게 out시켜주기.
				}
				
				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
 
}
