package Programmers1;

import java.util.ArrayList;

/*
 * 같은 숫자는 싫어
 */
public class Solution06 {
	public static void main(String[] args) {
		//int[] arr = {1,1,3,3,0,1,1};
		int[] arr = {4,4,4,3,3};
		solution(arr);
	}
	
	public static ArrayList solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
       
        
        for(int i=0; i <arr.length-1; i++) {
        	if(arr[i]==arr[i+1]) {
        		arr[i]=-1;
        	}
        }
        
        
        for(int num : arr) {
        	if(num >= 0) {
        		int i = 0;
        		list.add(num);
        		i++;
        	}
        }
        
        

//        for(int num : arr) {
//        	list.add(num);
//        }
        
//        for(int i=0; i<list.size()-1; i++) {
//        	if(list.get(i)==list.get(i+1)){
//        		list.remove(i);
//        		i=-1;
//        	}
//        	
//        }
        
        return list;
    }
}
