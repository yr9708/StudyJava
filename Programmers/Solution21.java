package Programmers1;

/*
 * 3진법 뒤집기
 */
public class Solution21 {
	public static void main(String[] args) {
		solution(125);
	}
	
	public static int solution(int n) {
        int answer = 0;
        

        
        String str = "";
        
        // 이렇게 풀었는데 시간초과가 뜬다.
//        int nmg = -1;
// 		  int dab = -1;
//        while(true) {
//        	dab = n/3;
//        	nmg = n%3;
//        	n = dab;
//        	str += nmg;
//        	
//        	if(dab==1) 
//        	break;
//        }
        
        while(n != 0) {
        	str += n%3;
        	n = n/3;
        }
        
        
        str = new StringBuffer(str).reverse().toString(); // 배열 거꾸로
        for(int i=0; i<str.length(); i++) {
        	answer += Character.getNumericValue(str.charAt(i)) * Math.pow(3,i);
        }

        System.out.println(answer);

        return answer;
    }
}
