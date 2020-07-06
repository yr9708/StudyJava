package com.dto;

// Data Transfer Object
public class MyTestDto {
	// MNO NUMBER
	private int mno;
	// MNAME VARCHAR2(20)
	private String mname;
	// NICKNAME VARCHAR2(20)
	private String nickName;
	
	public MyTestDto() {
		
	}
	
	public MyTestDto(int mno,String mname, String nickName) {
		this.mno=mno;
		this.mname=mname;
		this.nickName=nickName;
	}
	
	public int getMno() {
		return mno;
	}
	
	public void setMno(int mno) {
		this.mno=mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return mno+" "+mname+" "+nickName;
	}
}
