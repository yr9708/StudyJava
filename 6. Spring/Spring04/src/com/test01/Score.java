package com.test01;

public class Score {
   

   private String name;
   private int kor;
   private int eng;
   private int math;
   private int sum;
   private double avg;
   private String grade;
   
   public Score() {
      
   }
   
   public Score(String name, int kor, int eng, int math) {
      super();
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
   }
   
   
   public Score(String name, int kor, int eng, int math, int sum, double avg, String grade) {
      super();
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = sum;
      this.avg = avg;
      this.grade = grade;
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
      return math+kor+eng;
   }

   public void setSum(int sum) {
      this.sum = sum;
   }

   public double getAvg() {
      return (double)(getSum()/3);
   }

   public void setAvg(double avg) {
      this.avg = avg;
   }

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

   public void setGrade(String grade) {
      this.grade = grade;
   }
   
   public String toString() {
      return "이름:" + name + " 국어:" + kor + " 영어:" + eng + " 수학:" + math
            + " 총점:" + getSum() + " 평균:" + getAvg() + " 등급:" + getGrade(); 
   }


}