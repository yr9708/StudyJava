package beakjoon;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class beakjoon2607 {
/*
 * 영문 알파벳 대문자로 이루어진 두 단어가 다음의 두 가지 조건을 만족하면 같은 구성을 갖는다고 말한다.

두 개의 단어가 같은 종류의 문자로 이루어져 있다.
같은 문자는 같은 개수 만큼 있다.
예를 들어 "DOG"와 "GOD"은 둘 다 'D', 'G', 'O' 세 종류의 문자로 이루어져 있으며 양쪽 모두 'D', 'G', 'O' 가 하나씩 있으므로 이 둘은 같은 구성을 갖는다. 
하지만 "GOD"과 "GOOD"의 경우 "GOD"에는 'O'가 하나, "GOOD"에는 'O'가 두 개 있으므로 이 둘은 다른 구성을 갖는다.

두 단어가 같은 구성을 갖는 경우, 또는 한 단어에서 한 문자를 더하거나, 빼거나,
 하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우에 
 이들 두 단어를 서로 비슷한 단어라고 한다.

예를 들어 "DOG"와 "GOD"은 같은 구성을 가지므로 이 둘은 비슷한 단어이다.
 또한 "GOD"에서 'O'를 하나 추가하면 "GOOD" 과 같은 구성을 갖게 되므로 이 둘 또한 비슷한 단어이다. 
 하지만 "DOG"에서 하나의 문자를 더하거나, 빼거나, 바꾸어도 "DOLL"과 같은 구성이 되지는 않으므로 "DOG"과 "DOLL"은 비슷한 단어가 아니다.

입력으로 여러 개의 서로 다른 단어가 주어질 때, 첫 번째 단어와 비슷한 단어가 모두 몇 개인지 찾아 출력하는 프로그램을 작성하시오.

 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개의 단어를 입력할까요");
		int num= Integer.parseInt(sc.nextLine());
		String [] arr = new String[num];	//입력값
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("단어를 입력해주세요");
			String str = sc.nextLine();
			arr[i]=str;
		}
		
		System.out.println(Arrays.toString(arr));
		
		ArrayList<Character> wordList=new ArrayList<Character>();
		String s1=arr[0];	// 비교해야할 첫번째 단어
		char[] ch = s1.toCharArray();
					
		for(int j=0; j<ch.length; j++) {
			wordList.add(ch[j]);
		}
		
		System.out.println(wordList);
		
		int cnt=0;
		
		
		
		for(int i =0; i<wordList.size();i++) {
	//		if(i!=wordList.size()-1) 
			char[] c = arr[i+1].toCharArray();
		
			for(int j= 0 ; j<c.length; j++) {
				if(wordList.get(i)==c[j]) {
					
				}else {
					cnt++;
					System.out.println("맞지 않을때 갯수 "+cnt);
				}
			}
		}
		
		
		
		
		
		
		
	}
	
	

}
