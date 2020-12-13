package Programmers2;

import java.util.Arrays;
import java.util.Stack;

/*
 * 짝지어 제거하기
 */
public class Solution3 {
	public static void main(String[] args) {
		System.out.println(solution("cdcd"));
	}
	
	public static int solution(String s) {
		int answer = 0;
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			st.push(s.charAt(i)); // 일단 스택에 모두 담는다.
			System.out.println(st);
			if(st.size()>1) { 
				while(!st.isEmpty()) {
					char c1 = st.pop();
					char c2 = st.pop();
					if(c1!=c2) {
						st.push(c2);
						st.push(c1);
						System.out.println("st "+st);
						break;
					}else {
						break;
					}
				}
			}
		}
		
		System.out.println(st);
		
		if(st.size()==0) {
			answer = 1;
		}
		
		

		/*
		 *  스택으로 풀기 전 String 배열로 풀었을 때
		 *  테스트케이스는 다 통과하는데 효율성이 모두 실패가 떴다
		 *  코드시간이 8000ms 이상 나옴...
		 *  그래서 위의 코드인 스택을 사용하여 풀었다.
		 */

//		String[] arr = s.split("");
//		for(int i=0; i<arr.length-1; i++) {
//			if(arr[i].equals(arr[i+1])) {
//				arr[i] = "-1";
//				arr[i+1] = "-1";
//				
//			}
//		}
//		
//		System.out.println(Arrays.toString(arr));
//		
//		String reply = "";
//		int index = 0;
//		for(int i=0; i<arr.length; i++) {
//			System.out.println("reply: "+reply+" i: "+i+" arr[i]: "+arr[i]);
//			if(!arr[i].equals("-1")) {
//				if(reply.equals(arr[i])) {
//					arr[index] = "-1";
//					arr[i] = "-1";
//					i = 0;
//				}
//				reply = arr[i];
//				index = i;
//			}
//		}
//		
//		int cnt = 0;
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i].equals("-1")) {
//				cnt++;
//			}
//		}
//		
//		if(cnt==arr.length) {
//			answer = 1;
//		}
//		
//		System.out.println(Arrays.toString(arr));

		
		
		return answer;
	}
}
