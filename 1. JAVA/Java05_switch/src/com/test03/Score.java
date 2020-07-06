package com.test03;

public class Score {
	public double getAvg(int kor, int eng, int math) {
		return (double)(kor+eng+math)/3; // (kor+eng+math)/3.0
	}
	
	public String getGrade(double avg) {
		
/*		String res="";
		
		if (90<avg) {
			res="A";
		}else if(80<=avg && 89>=avg){
			res="B";
		}else if(79<=avg && 70>=avg) {
			res="C";
		}else if(69<=avg && 60>=avg) {
			res="D";
		}else {
			res="F";
		}
		
		return res;*/
		
		
//		int i = Integer.parseInt(String.valueOf(avg));
		
		// switch에 들어갈 수 있는 파라미터는 정수형, 문자형, 문자열 만 가능하다.
		switch((int)avg/10) { // 10으로 나누어서 십의 자리만 남겨서 검증하기
		
		case 10 : 
		case 9 : return "A"; 
		case 8 : return "B"; 
		case 7 : return "C"; 
		case 6 : return "D"; 
		
		default : return "F";
		
		}
		
		
	}
	
	
	
}

