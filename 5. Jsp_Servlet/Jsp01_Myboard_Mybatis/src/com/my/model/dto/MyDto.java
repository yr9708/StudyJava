package com.my.model.dto;

import java.util.Date;

public class MyDto {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
	public MyDto() {
		
	}
	
	public MyDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		this.myno = myno;
		this.myname=myname;
		this.mytitle=mytitle;
		this.mycontent=mycontent;
		this.mydate=mydate;
	}
	// insert 할 때 : myname, mytitle, mycontent : 메소드 오버로딩을 하기 위해선 파라미터의 타입이나 이름이 꼭 달라야 한다.
	public MyDto(String myname, String mytitle, String mycontent) {
		this.myname=myname;
		this.mytitle=mytitle;
		this.mycontent=mycontent;
	}
	
	// update 할 때 : myno, mytitle, mycontent;
	public MyDto(int myno, String mytitle, String mycontent) {
		this.myno=myno;
		this.mytitle=mytitle;
		this.mycontent=mycontent;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
}
