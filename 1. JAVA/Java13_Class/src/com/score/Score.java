package com.score;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;

	// 기본 생성자
	public Score() {
		
	}
	
	// 파라미터 4개짜리 생성자(초기화)
	public Score(String name, int kor, int eng, int math) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	
	 // 모든 field에 대한 getter setter
	public int getKor() {
		return this.kor;
	}
	
	public void setKor(int kor) {
		this.kor=kor;
	}
	
	public int getEng() {
		return this.eng;
	}
	
	public void setEng(int eng) {
		this.eng=eng;
	}
	
	public int getMath() {
		return this.math;
	}
	
	public void setMath(int math) {
		this.math=math;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	//모든 field에 대한 총 합 리턴
	public int getSum() {
		return this.kor+this.eng+this.math;
	}
	
	// 모든 field에 대한 평균 리턴
	public double getAvg() {
		return ((double)getSum())/3;
	}
	
	// 평균 점수
	// 100 ~ 90 :A
	// 89 ~ 80 : B
	// 79 ~ 70 : C
	// 69 ~ 60 : D
	// 59 ~ 50 : F
	
	public String getGrade() {
		String s ;
		switch((int)getAvg()/10) {
			case 10 :
			case 9 :s="A"; break;
			case 8: s="B"; break;
			case 7: s="C"; break;
			case 6: s="D"; break;
			default :s="F";
		}
		return s;
	}
	
	// 이름 : x	국어 : x 영어 : x 수학 : x
	// 총점 : x 평균 : x 등급 : x
	// 로 리턴하자
	public String toString() {
		
		return "이름 :"+this.name+" 국어 :"+this.kor+" 영어 :"+this.eng+" 수학 :"+this.math+"\n 총점 :"+getSum()+" 평균 :"+getAvg()+" 등급 :"+getGrade();
				
	}
}
