package com.test02;

public class BreakTest {

	public static void main(String[] args) {
		/*
		 * A B C D E
		 * F G H I J
		 * K L M N O
		 * P Q R S T
		 * U V W X Y
		 * Z
		 */

		prn();
	}

	public static void prn() {
		int count = 0;
		char c = 'A';
		boolean stop = false;
		
		while(!stop) { //true
			
			while(true) {
				System.out.print(c + " ");
				c++; 	// ch[i] = (char)('a'+i);
				count++;
				
				if(count%5==0) {
					break;
				}

				if(count==26) {
					stop=true;
					break;
				}
			}
			System.out.println();
		}
	}
}
