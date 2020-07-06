package com.generic;


// t : type

public class Emp<T> {
	
	private T empno;
	private String ename;
	
	
	public Emp() {
		super();
	}

	public Emp(T empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}

	public T getEmpno() {
		return empno;
	}

	public void setEmpno(T empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	

}
