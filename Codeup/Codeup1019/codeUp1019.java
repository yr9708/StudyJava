package codeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class codeUp1019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] num = input.split("\\.");
		
		System.out.printf("%04d.",Integer.parseInt(num[0]));
		
		for(int i=1; i<3; i++) {
			if(i==1) {
				System.out.printf("%02d.",Integer.parseInt(num[i]));
			}else {
				System.out.printf("%02d",Integer.parseInt(num[i]));
				
			}
		}
		
		
		
		Scanner sc = new Scanner(System.in);
		float f = sc.nextFloat();
		
	}
}
