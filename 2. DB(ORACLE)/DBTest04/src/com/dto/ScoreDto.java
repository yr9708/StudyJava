package com.dto;

//Date Transfer Object : 값을 전달하는 것이지 계산하는 건 좋은것이 아님, 계산은 biz에서!
public class ScoreDto {
	private String s_name;
	private int s_kor;
	private int s_eng;
	private int s_math;
	private int s_sum;
	private double s_avg;
	private String s_grade;
	
	public ScoreDto() {}

	public ScoreDto(String s_name, int s_kor, int s_eng, int s_math, int s_sum, int s_avg, String s_grade) {
		super();
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
		this.s_sum = s_sum;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_kor() {
		return s_kor;
	}

	public void setS_kor(int s_kor) {
		this.s_kor = s_kor;
	}

	public int getS_eng() {
		return s_eng;
	}

	public void setS_eng(int s_eng) {
		this.s_eng = s_eng;
	}

	public int getS_math() {
		return s_math;
	}

	public void setS_math(int s_math) {
		this.s_math = s_math;
	}

	public int getS_sum() {
		return s_math+s_kor+s_eng;
	}

	public void setS_sum(int s_sum) {
		this.s_sum = s_sum;
	}

	public double getS_avg() {
		return  (double)(s_math+s_kor+s_eng)/3;
	}

	public void setS_avg(Double s_avg) {
		this.s_avg = s_avg;
	}

	public String getS_grade() {
		String grade;
		
		switch((int)getS_avg()/10) {
		case 10 :
		case 9 :
			grade = "A";
			break;
		case 8 :
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6 :
			grade = "D";
			break;
		default : grade = "F";
		}
	return grade;
	}

	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}

	@Override
	public String toString() {
		return String.format("%3s %3d %3d %3d %3d %.2f %3s",s_name, s_kor, s_eng, s_math, s_sum, s_avg, s_grade);
	};
	
	
	
	
}
