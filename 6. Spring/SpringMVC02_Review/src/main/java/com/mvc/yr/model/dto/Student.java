package com.mvc.yr.model.dto;

public class Student {
	private String name;
	private int grade;
	private String className;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int grade, String className) {
		this.name = name;
		this.grade = grade;
		this.className = className;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", className=" + className + "]";
	}
	
	
}
