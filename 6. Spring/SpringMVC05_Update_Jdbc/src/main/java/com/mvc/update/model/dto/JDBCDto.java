package com.mvc.update.model.dto;

import java.sql.Date;

public class JDBCDto {
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	public JDBCDto() {
		super();
	}

	public JDBCDto(int seq, String writer, String title, String content, Date regdate) {
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
