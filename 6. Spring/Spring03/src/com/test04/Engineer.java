package com.test04;

public class Engineer {
	private Emp emp;
	private String dept;
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	
	public Engineer() {
		
	}

	@Override
	public String toString() {
		return emp + "\tºÎ¼­ : "+dept;
	}
	
	
}
