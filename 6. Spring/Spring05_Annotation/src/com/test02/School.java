package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	@Autowired 
	// byType -> byName 순서로 찾음
	// 값 하나만 연결해서 사용 할 수 있다.
	@Qualifier("seo")
	private Student student;
	private int grade;
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	public School(Student student, int grade) {
		this.student = student;
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "student : " + student + ", grade : " + grade;
	}
	
	
}
