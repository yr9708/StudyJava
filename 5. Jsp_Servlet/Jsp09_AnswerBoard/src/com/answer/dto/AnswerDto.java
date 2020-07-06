package com.answer.dto;

import java.util.Date;

public class AnswerDto {
	private int boardno;
	private int groupno;
	private int groupseq;
	private int titletab;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	public AnswerDto() {
		
	}
	
	
	// selectone
	public AnswerDto(int titletab, String title, String content, String writer, Date regdate) {
		super();
		this.titletab = titletab;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}
	
	// insert
	public AnswerDto(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	// update
	public AnswerDto(int boardno, String title, String content, String writer) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	

	public AnswerDto(int boardno, int groupno, int groupseq, int titletab, String title, String content, String writer,
			Date regdate) {
		super();
		this.boardno = boardno;
		this.groupno = groupno;
		this.groupseq = groupseq;
		this.titletab = titletab;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}	
	




	public int getboardno() {
		return boardno;
	}

	public void setboardno(int boardno) {
		this.boardno = boardno;
	}

	public int getgroupno() {
		return groupno;
	}

	public void setgroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getGrouopSeq() {
		return groupseq;
	}

	public void setGrouopSeq(int groupseq) {
		this.groupseq = groupseq;
	}

	public int gettitletab() {
		return titletab;
	}

	public void settitletab(int titletab) {
		this.titletab = titletab;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AnswerDto [boardno=" + boardno + ", groupno=" + groupno + ", groupseq=" + groupseq + ", titletab="
				+ titletab + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate
				+ "]";
	}
	
	
}
