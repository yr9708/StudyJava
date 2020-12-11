package Programmers1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 모의고사
 */
public class Solution40 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		solution(answers);
	}
	
    public static int[] solution(int[] answers) {
        int[] supoja1 = new int[answers.length];
        int[] supoja2 = new int[answers.length];
        int[] supoja3 = new int[answers.length];
        
        int cnt = 1;
        for(int i=0; i<supoja1.length; i++) {
        	supoja1[i] = cnt;
        	cnt++;
        	
        	if(cnt>5) {
        		cnt = 1;
        	}
        }
        
        cnt = 0;
        for(int i=0; i<supoja2.length; i++) {
        	if(i==0) {
        		supoja2[i] = 2;
        	}else if(i%2==0) {
        		supoja2[i] = 2;
        	}else{
        		cnt++;
        		if(cnt==2) {
        			cnt=3;
        		}else if(cnt==6) {
        			cnt=1;
        		}
        		supoja2[i] = cnt;
        	}
        }
         
        int num = 0; // 들어가는 숫자
        cnt = 0; // 카운트 되는 숫자

        for(int i=0; i<supoja3.length; i++) {
        	System.out.println("i:"+i);
        	System.out.println("cnt:"+cnt);
        	System.out.println("num:"+num);
        	if(i==0 || i%10==0) {
        		supoja3[i] = 3;
        	}else if(i%10==1) {
        		supoja3[i] = 3;
        		num++;
        	}else {
        		if(cnt==2) {
        			if(num==2) { // 2가 두번 나왔을때 뒤에를 4로 바꿔주기
        				num++;
        			}
        			if(num==6) {
        				num = 0;
        			}
        			num++;
        			cnt = 0;
        		}
        		cnt++;
        		supoja3[i] = num;
        	}
        }
        
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        for(int i=0; i<answers.length; i++) {
        	if(answers[i]==supoja1[i]) {
        		res1++;
        	}
        	if(answers[i]==supoja2[i]) {
        		res2++;
        	}
        	if(answers[i]==supoja3[i]) {
        		res3++;
        	}
        }
        
        int topScore = Math.max(Math.max(res1, res2), res3);
        
        List<Integer> list = new ArrayList<>();
        if(topScore==res1) {
        	list.add(1);
        }
        if(topScore==res2) {
        	list.add(2);
        }
        if(topScore==res3) {
        	list.add(3);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
       
        System.out.println(Arrays.toString(supoja1));
        System.out.println(Arrays.toString(supoja2));
        System.out.println(Arrays.toString(supoja3));
        
        return answer;
    }
}
