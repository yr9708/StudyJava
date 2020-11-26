package Programmers1;

import java.util.Arrays;

/*
 * 완주하지 못한 선수
 */
public class Solution15 {
	public static void main(String[] args) {
		//String[]participant = {"leo", "kiki", "eden"};
		//String[] completion = {"eden","kiki"};

		String[]participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		//String[] participant = {"mislav", "stanko", "mislav", "ana"};
		//String[] completion = {"stanko", "ana", "mislav"};
		
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//        
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        
//        System.out.println(Arrays.toString(participant));
//        System.out.println(Arrays.toString(completion));

//      for(int i=0; i<completion.length; i++) {
//    	  if(!participant[i].equals(completion[i])) {
//    		  answer = participant[i];
//    	  }
//    		 
//    	  
//    	  answer = participant[i+1];
//      }
//        
//        
//        
//        
//        return answer;
        
        
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));
        int i;      //밑에서 completion까지 다 확인하고 모두 다 같은 이름일시에 participant의 마지막번지가 이름이 같지 않은애
        for(i =0; i<completion.length;i++){
        	System.out.println(participant[i] + " : " + completion[i]);
            if(!participant[i].equals(completion[i])){
            	System.out.println("다른애 : "+participant[i]);
                return participant[i];
            }   
        }
       
        return participant[i];
    }
}
