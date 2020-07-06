package com.test01;

public class MTest {
	
	private static String str ="The String class represents character strings.";
	
	public static void main(String[] args) {
//		String s = "Hello";
//		System.out.println(s+1+2);
//		System.out.println(s);
//		s=s+1+2;
//		System.out.println(s);
		
		
		
		// 1. str의 전체길이 출력
		prn01();
		// 2. str 전체를 대문자로 바꿔서 출력하자.
		prn02();
		// 3. str 전체를 소문자로 바꿔서 출력
		prn03();
		// 4. str에서 첫 번째 c의 인덱스 위치
		prn04();
		prn05();
		prn06();
		prn07();
		prn08();
		prn09();
		prn10();
	}

	// 10 전체를 역순으로 출력하자
	private static void prn10() {
		char[] ch=str.toCharArray();
		for(int i=ch.length-1; i>=0; i--) {
			System.out.printf("%c",ch[i]);
		}
	}

	// 9.공백제거 후 출력하자
	private static void prn09() {
		char[] ch=str.toCharArray();
		for(int i=0; i<ch.length; i++) {
			if(ch[i]==' ') {
				continue;
			}else {
				System.out.printf("%c",ch[i]);
			}
		}
		System.out.println();
		
		System.out.println(str.trim());
		System.out.println(str.replace(" ", ""));
		System.out.println(str.replaceAll(" ", ""));	// 정규표현식(regex)
		
//		int [] arr = {};
//		System.out.println(arr.length);
		
		
	}

	// 8.str을 char[]로 출력하되 대문자만 출력하자. 그리고 대문자의 갯수를 출력하자.
	private static void prn08() {
		char[] ch=str.toCharArray();
		int cnt =0;
		
		for(int i =0; i<ch.length;i++) {
			//if(ch>='A' && ch<='Z')
			if(Character.isUpperCase(ch[i])) {
				System.out.printf("%c ",ch[i]);
				cnt++;
			}
		}
		System.out.println("\npm08 대문자의 갯수 : "+cnt);
	}

	// 7.str을 char[]로 출력하되, 'c'만 출력하자. 그리고 c의 갯수를 출력하자.
	private static void prn07() {
		int cnt = 0;
		char[] ch=str.toCharArray();
		for(int i =0; i<ch.length;i++) {
		//	System.out.print(ch[i]+" ");
			if(ch[i]=='c' || ch[i]=='C') {
				System.out.printf("%c ",ch[i]);
				cnt++;
			}
		}
		System.out.println("\npm07 c의 갯수 : "+cnt);
	}

	// 6. "character"를 찾아서 대문자로 변경 후, 변경된 str 전체 출력
	private static void prn06() {
		
		System.out.println("pm06 : "+str.replace("character","character".toUpperCase() ));
		
		String target = "character";
		int startIdx = str.indexOf(target);
		System.out.println(startIdx);
		int enIndx = startIdx+target.length();
		System.out.println(enIndx);
		String upper = str.substring(startIdx, enIndx).toUpperCase();
		System.out.println(str.replace(target, upper));
	}

	// 5. "class"를 "java"로 바꿔서 
	private static void prn05() {
		System.out.println("pm05 : "+str.replace("class", "java"));
	}
	

 	private static void prn04() {
		System.out.println("pm04 : "+str.indexOf("c"));
		
	}

	private static void prn03() {
		System.out.println("pm03 : "+str.toLowerCase());
		
	}

	private static void prn02() {
		System.out.println("pm02 : "+str.toUpperCase());
	}

	private static void prn01() {
		System.out.println("pm01 : "+str.length());
		
	}
	
}
