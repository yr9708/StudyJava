package com.boot.jpa.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //table로 만들고 싶은 객체
@Table(name="MYBOARD") // MYBOARD라는 table과 JpaDto가 연결될거다
public class JpaDto {
	@Id //primary key
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //jpa(hibernate)가 알아서 생성해서 알아서 사용할 수 있게 설정해주기, auto, sequence 등으로 바꿔줄수도있다.
	private int myno;
	
	@Column
	private String myname;
	
	@Column
	private String mytitle;
	
	@Column
	private String mycontent;
	
	@Column(updatable=false)
	@Temporal(TemporalType.DATE) //날짜까지만 나오게 timestap 쓰면 날짜시간까지 나오
	private Date mydate;
	
	public JpaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JpaDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
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
