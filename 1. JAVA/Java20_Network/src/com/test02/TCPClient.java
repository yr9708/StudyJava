package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class TCPClient implements Runnable {
	@Override
	public void run() {

		try {
			Socket clientSocket;
			PrintWriter out = null;
			BufferedReader in = null;
			BufferedReader stdin = null;

			System.out.println("[client] server에 접속합니다...");
			clientSocket = new Socket("localhost", 7777);

			out = new PrintWriter(clientSocket.getOutputStream(), true); // char->byte로 변경
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 캐릭터로 된 inputStream을 defaultCharBufferSize로 만든다.
			stdin = new BufferedReader(new InputStreamReader(System.in));

			String inputLine;
			while ((inputLine = stdin.readLine()) != null) {
				out.println(inputLine);
				System.out.println("[client] server로부터 다시 받은 메세지 : " + in.readLine());
			}

			out.close();
			in.close();
			stdin.close();
			clientSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new TCPClient()).start();
	}
}
