package Programmers1;

import java.util.Arrays;

/*
 * 비밀지도
 */
public class Solution38 {
	public static void main(String[] args) {
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		solution(6,arr1,arr2);
	}
	
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[]result1 = new String[n];
        String[]result2 = new String[n];
        String str = "";
        int nmg = 0;
        for(int i=0; i<arr1.length; i++) { // 첫번째 배열지도 이진법으로 풀어주기
        	nmg = arr1[i]%2;
        	arr1[i] = arr1[i]/2;
        	if(arr1[i]!=0) {
        		str += nmg;
        		i--;
        	}else{
        		str += nmg;
        		if(str.length()<n) {
        			while(str.length()<n) {
        				str += 0;        				
        			}
        		}
        		result1[i] = new StringBuffer(str).reverse().toString();
        		str = "";
        	}
        }
        
        str = "";
        nmg = 0;
        for(int i=0; i<arr2.length; i++) { // 두번째 배열지도 이진법으로 풀어주기
        	nmg = arr2[i]%2;
        	arr2[i] = arr2[i]/2;
        	if(arr2[i]!=0) {
        		str += nmg;
        		i--;
        	}else{
        		str += nmg;
        		if(str.length()<n) {
        			while(str.length()<n) {
        				str += 0;
        			}
        		}
        		result2[i] = new StringBuffer(str).reverse().toString();
        		str = "";
        	}
        }
        
        // 두개의 배열 다 같이 비교해서 결과에 넣기
        for(int i=0; i<answer.length; i++) {
        	String[] number = result1[i].split("");
        	String[] number2 = result2[i].split("");
        	String res = "";
        	for(int j=0; j<number.length; j++) {
        		if(number[j].equals("1") || number2[j].equals("1")) {
        			res += "#";
        		}
        		if(number[j].equals("0") && number2[j].equals("0")) {
        			res += " ";
        		}
        	}
        	answer[i] = res;
        }

//        answer[i] = new StringBuffer(str).reverse().toString();
//        System.out.println(answer[i]);
        return answer;
    }
	
}
