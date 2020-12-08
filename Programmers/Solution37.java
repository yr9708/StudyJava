package Programmers1;

import java.util.Arrays;

/*
 * 다트게임
 */
public class Solution37 {
	public static void main(String[] args) {
		solution("3T*2S*5D");
	}
	
    public static int solution(String dartResult) {
    	//single, double, triple 점수1제곱, 점수2제곱, 점수3제곱
    	// * 바로전에 얻은 점수들 각 2배, # 해당점수는 마이너스
    	// * 처음에 나오면 해당 점수만 2배, 중첩가능 4배 
    	// * + # 중첩 가능 -2배
    	
    	// 점수는 0에서 10사이의 정수
    	// 보너스는 S D T 중 하나
    	// 옵션은 * 또는 # 중 하나, 없을 수도 있음
    	
        int answer = 0;
        int[] result = new int[3];
        
        int j = 0; // 결과값이 담긴 번지수를 알기위한 변수
        String[] dartArr = dartResult.split("");
        System.out.println(Arrays.toString(dartArr));
        
        int cnt = 0; // 문자가 오기전까지의 숫자 갯수 ex)2이면 1의자리, 3면 10의자리 (문자까지 합해서 count됨)
        
        
        for(int i=0; i<dartArr.length; i++) {
        	cnt++;
        	if(dartArr[i].equals("S")) {	
        		if(cnt==3) {
        			int num = Integer.parseInt(dartArr[i-2]+dartArr[i-1]);
        			result[j] =  (int) Math.pow(num, 1); 
        		}else {        			
        			result[j] =  (int) Math.pow(Integer.parseInt(dartArr[i-1]), 1); 
        		}
        		j++;
        		cnt=0;
        	}else if(dartArr[i].equals("D")) {
        		if(cnt==3) {
        			int num = Integer.parseInt(dartArr[i-2]+dartArr[i-1]);
        			result[j] =  (int) Math.pow(num, 2); 
        		}else {
        			result[j] =  (int) Math.pow(Integer.parseInt(dartArr[i-1]), 2); 
        		}
        		j++;
        		cnt=0;
        	}else if(dartArr[i].equals("T")) {
        		if(cnt==3) {
        			int num = Integer.parseInt(dartArr[i-2]+dartArr[i-1]);
        			result[j] =  (int) Math.pow(num, 3); 
        		}else {
        			result[j] =  (int) Math.pow(Integer.parseInt(dartArr[i-1]), 3); 	
        		}
        		j++;
        		cnt=0;
        	}else if(dartArr[i].equals("*")) {
        		j--; // 현재 j를 알기 위해서 -- 해줌
        		if(j==0) {
        			result[0] = result[0] * 2;
        		}else {
        			for(int k=j-1; k<=j; k++) {
        				result[k] = result[k] * 2;
        			}        			
        		}
        		j++; // 다시 되돌려
        		cnt=0;
        	}else if(dartArr[i].equals("#")) {
        		int num = 0;
        		if(j!=0) {
        			num = j-1;
        		}else {
        			num = j;
        		}
        		result[num] = result[num] * -1;
        		cnt=0;
        	}
        	
        }
        
        System.out.println(Arrays.toString(result));
        
        for(int i=0; i<result.length; i++) {
        	answer += result[i];
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
