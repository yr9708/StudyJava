package Programmers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/*
 * 스킬트리
 */
public class Solution2 {
	public static void main(String[] args) {
//		String[] skill_trees= {"BACDE", "CBADF", "AECB", "BDA"};
//		System.out.println(solution("CBD",skill_trees));
//		System.out.println(solution("CBD", new String[] { "AQBD" }));
//	    System.out.println(solution("CBD", new String[] { "C" }));
	    System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA", "AQWER" }));
//	    System.out.println(solution("ABC", new String[] { "OPQ" }));
//	    System.out.println(solution("CBD", new String[] { "CED" }));
//	    System.out.println(solution("CABDSER", new String[] { "ANM", "ER", "REWQ", "CL" }));
	    solution2("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA", "AQWER" });
	}
	
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skills = skill.split("");
        Stack<String> stack = new Stack<>(); //스택 생성
        int cnt = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
        	String[] tree = skill_trees[i].split("");
        	for(int j=0; j<tree.length; j++) { //검사할 글자수만큼
        		for(int k=0; k<skills.length; k++) { 
        			if(skills[k].equals(tree[j])) { //skill의 한글자씩 비교, 같으면 스택에 담는다
        				stack.push(tree[j]);
        				cnt++; // 같은 문자가 있으면 cnt 올리기
        			}
        		}
        	}
        	if(cnt!=0){
        		int b = 0;
        		for(int t=0; t<skills.length; t++) {
        			if(skills[t].equals(stack.peek())) { //처음 같은 문자가 어디 번지에 있는지 확인
        				b = t;
        				break;
        			}
        		}
        		for(int n=b; n>=0; n--) { //위에서 나온 번지수부터 확인
        			if(stack.peek().equals(skills[n])) { //스택에 있는 문자와 확인하는 번지수와 문자가 같으면 stack에서 뽑기
        				stack.pop();
        			}else {
        				break; //문자가 다르면 break; 확인 할 필요 없음
        			}
        			if(stack.size()==0 && n!=0 ) { //★만약 스택에 있는 문자는 없는데 skill에는 문자가 남아있다면 답이 아님, break;
        				answer--;
        				break;
        			}
        		}

        		if(stack.size()==0) {
        			answer++;
        		}else {
        			stack.removeAllElements(); // 스택 초기화
        		}
        	}else { //같은 문자가 하나도 없으면 정답으로 처리
        		answer++;
        	}
        	cnt = 0;
        }
        return answer;
	}	
	
	public static int solution2(String skill, String[] skill_trees) {
		int answer = 0;
		ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
		Iterator<String> it = skillTrees.iterator();
		
		while(it.hasNext()) { // indexOf() -> 특정문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환, 찾지못했을 경우 -1 리턴
			if(skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
				// [^skill] skill 문자열을 제외하고 다른 글자일 경우 "" 처리 -> 정규식표현사용
				it.remove();
			}
		}

		System.out.println(skillTrees);
		answer = skillTrees.size();
		
		return answer;
	}
}
