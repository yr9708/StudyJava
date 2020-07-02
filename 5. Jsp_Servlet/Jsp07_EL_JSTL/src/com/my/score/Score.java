package com.my.score;

public class Score {
	private String name;
	private int math;
	private int eng;
	private int kor;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
		
	}

	public Score(String name, int math, int eng, int kor, int sum, double avg, String grade) {
		super();
		this.name = name;
		this.math = math;
		this.eng = eng;
		this.kor = kor;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}
	

	public Score(String name, int math, int eng, int kor) {
		super();
		this.name = name;
		this.math = math;
		this.eng = eng;
		this.kor = kor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getSum() {
		return kor+math+eng;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return getSum()/3;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		
		int res = (int) Math.floor(getAvg()/10);
		
		switch(res) {
		case 10 : grade = "A"; 
				break;
		case 9 : grade = "B";
		case 8 : grade = "B";
				break;
		case 7 : grade = "C";
				break;
		case 6 : grade ="D"; break;
		default : grade = "F";
		
		}
		
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", math=" + math + ", eng=" + eng + ", kor=" + kor + ", sum=" + sum + ", avg="
				+ avg + ", grade=" + grade + "]";
	}
	
	
	
	
}
