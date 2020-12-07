package Programmers1;

import java.util.Arrays;

/*
 * 예산 (이분탐색)
 */
public class Solution35 {
	public static void main(String[] args) {
		int[] d = {2,2,3,3,1};
		int budget = 9;
		
		solution(d,budget);
	}
	
    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        
        // 낮은 수 부터 다 더해줘야 많은 부서가 나옴, 그래서 sort
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
        	sum += d[i];
        	System.out.println(sum);
        	// 다 더한게 예산보다 크면 크지 않았던 답이 나온 i로
        	if(sum > budget) { 
        		answer = i;
        		break;
        	}
        	// 다 더한게 예산과 같으면 0번부터 시작했으니까 +1
        	if(sum == budget) {
        		answer = i+1;
        		break;
        	}
        }
        
        // 다 더해도 예산보다 작으면 부서의 갯수 리턴
        if(sum < budget) {
        	answer = d.length;
        }
        
        System.out.println("answer : "+answer);
        
        return answer;
    }
}
