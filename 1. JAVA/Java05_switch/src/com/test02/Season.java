package com.test02;

class Season {
	
	public static String prn (int month) {
		
		/*
		 * String result="";
		 * 
		 * switch(month) {
		 * 
		 * case 12: case 1 : case 2: 
		 * result="겨울"; 
		 * break; 
		 * case 3: case 4: case 5:
		 * result="봄"; 
		 * break; 
		 * case 6: case 7: case 8: 
		 * result="여름"; 
		 * break; 
		 * case 9 : case10: case 11: result="가을"; break;
		 * 
		 * 
		 * }
		 * 
		 * return result;
		 */
		
		switch(month) {
		case 12: case 1: case 2:
			return "겨울";
		case 3: case 4: case 5:
			return "봄";
		case 6: case 7: case 8:
			return "여름";
		case 9: case 10: case 11:
			return "겨울";
			
		default: return "잘못된 입력값입니다";
			
		}
		
	}

}
