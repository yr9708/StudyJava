package codeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeUp1048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] num =str.split(" ");
		int a = Integer.parseInt(num[0]);
		int b = Integer.parseInt(num[1]);
		if(a<0) {
			System.out.println("a값 재입력");
			a =Integer.parseInt(br.readLine());
		}
		if(b>10) {
			System.out.println("b값 재입력");
			b=Integer.parseInt(br.readLine());
		}
		
		int result = (int)((int) a*(Math.pow(2,b)));
		System.out.println(result);
	}
}
