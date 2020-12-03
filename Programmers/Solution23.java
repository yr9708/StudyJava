package Programmers1;


/*
 * 제일 작은 수 제거하기
 */
public class Solution23 {
	public static void main(String[] args) {
		int[] arr = {4,3,2,1,10,5};
	//	int[] arr = {10};
	//	int[] arr = {10,10};
		solution(arr);
	}
	
	 public static int[] solution(int[] arr) {
	    int [] answer = { };
	    
	    // 하나의 변수를 정해서 그것보다 작으면 계속 바꿔주기!
	    
	    if(arr.length==1) {
	    	answer = new int[1];
	    	answer[0] = -1;
	    	return answer;
	    }else {
	    	int num = arr[0];
	    	for(int i=0; i<arr.length; i++) {
	    		if(arr[i]<num) {
	    			num = arr[i];
	    		}
	    	}
	    	
	    	answer = new int[arr.length-1];
	    	int i = 0;
	    	int k = 0;
	    	for(int a : arr) {
	    		if(a!=num) {
	    			answer[k] = arr[i];
	    			i++;
	    			k++;
	    		}else {
	    			i++;
	    		}
	    		
	    	}

	    	
	    	return answer;
	    	
	    }
  
	 }
}
