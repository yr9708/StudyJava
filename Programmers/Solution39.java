package Programmers1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 실패율
 */
public class Solution39 {
	public static void main(String[] args) {
	//	int[] stages = {2,1,2,6,2,4,3,3};
	//	int[] stages = {4,4,4,4,4};
		int[] stages = {1,2,3,4,5,6,7};
		solution(8,stages);
	}
	
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();
        int cnt = 0;
        int bunMo = stages.length;
        for(int i=1; i<=N; i++) {
        	for(int j=0; j<stages.length; j++) {
        		if(i==stages[j]) {
        			cnt++;
        		}
        	}
        	double fail = (double)cnt/bunMo;
        	if(Double.isNaN(fail)) { // stages에 도달하지 못한 사람이 있을 경우 NaN으로 되기 때문에 이부분을 처리해줘야한다.
        							 // fail이 NaN일 경우 0.0으로 처리해주기. 
        		fail = 0.0;
        	}
        	map.put(i, fail);
        	bunMo = bunMo - cnt;
        	cnt = 0;
        }
        
        Double[] value = new Double[N];
        for(int i=0; i<value.length; i++) {
        	value[i] = map.get(i+1);
        }
        
        Arrays.sort(value,Collections.reverseOrder());
        
        int index = 0;
        for(int i=0; i<value.length; i++) {
        	for(int j=1; j<=value.length; j++) {
        		if(value[i]==map.get(j)) {
        			answer[index] = j;
        			index++;
        		}
        	}
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}
