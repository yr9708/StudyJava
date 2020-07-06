package com.compare;

import java.util.Iterator;

public class Score implements Comparable<Score> {

	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
		
	}
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getSum() {
		return kor+eng+math;
	}
	
	public double getAvg() {
		return (double)(kor+eng+math)/3;
	}
	
	
	public String getGrade() {
		String s ;
		
		switch((int)(getAvg()/10)) {
			case 10 :
			case 9 : 
				s="A"; 
				break;
			case 8: 
				s="B"; 
				break;
			case 7: 
				s="C"; 
				break;
			case 6: 
				s="D"; 
				break;
			default :s="F";
		}
		return s;
	}
	
	public String toString() {
		
		return "이름 :"+this.name+" 국어 :"+this.kor+" 영어 :"+this.eng+" 수학 :"+this.math+"\n 총점 :"+getSum()+" 평균 :"+getAvg()+" 등급 :"+getGrade();
				
	}


	@Override
	public int compareTo(Score other) {
		
		/*
		 * 1 이면 앞의 인자가 더 큰 값
		 * 0 이면 같은 값
		 * -1 이면 뒤의 인자가 더 큰 값 
		 */
//		Score other = (Score) o;
		
//		return this.getName().compareTo(other.getName());	// 이름을 기준으로 내림차순
		
		
//		내림차순
		
//		if(this.getName() > other.getName()){
//			return 1;
//		}else if(this.getKor() < other.getKor()) {
//			return -1;
//		}else {			
//			return 0;	// 같은거
//		}
//		
		
// 평균이 작은 것부터 큰것까지 정렬 (오름차순)	내가 클 때 return 값은 1; (양수)
// 만일 평균이 같다면 국어 점수가 큰것부터 작은것으로 정렬(내림차순)	내가 클때 return 값은 -1;(음수)
		
		if(this.getAvg() > other.getAvg()) {
			return 1;
		}else if(this.getAvg() < other.getAvg()) {
			return -1;
		}else {
			
			if(this.getKor() > other.getKor()) {
				return -1;
			}else if(this.getKor() < other.getKor()) {
				return 1;
			}else {
				return 0;
			}
			
			
			
			
		}
		
	}
	
}
