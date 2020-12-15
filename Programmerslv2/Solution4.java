package Programmers2;

import java.util.Stack;

/*
 * 올바른 괄호
 */
public class Solution4 {
	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}
	
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
        	if(stack.size()==0 && s.charAt(i)==')') { // stack에 올라간 것이 없고 (=사이즈가0일때) 처음 시작이 ')' 일때 리턴 false
        		answer = false;
        		return answer;
        	}
        	if(s.charAt(i)=='(') { // 검사하는 값이 '(' 이거면 stack에 올리고
        		stack.push(s.charAt(i));        		
        	}else if(s.charAt(i)==')'){ // 검사하는 값이 ')' 이거면 stack에서 뺀다.  그래서 아무것도 없게끔 만들어주는 것이 true
        		stack.pop();
        	}
        }

        if(stack.size()!=0) {
        	answer = false;
        }
        
        return answer;
    }
}
