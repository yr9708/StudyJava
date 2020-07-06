package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class MTest02 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://search.pstatic.net/common/?src=http%3A%2F%2Fkinimage.naver.net%2F20180708_47%2F1531017554873rl9en_JPEG%2F1531017554668.jpg&type=b400");
		
		byte[] b= new byte[1];
		
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		
		DataInputStream di = new DataInputStream(urlConnection.getInputStream());
		FileOutputStream fo = new FileOutputStream("data.jpeg");
		
		while(di.read(b,0,1)!=-1) {
			fo.write(b,0,1);
		}
		
		fo.close();
		di.close();
		
	}
}
