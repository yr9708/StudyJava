package com.answer.model.dao;

import java.util.List;

import com.answer.model.dto.AnswerDto;

public interface AnswerDao {

	String SELECT_LIST_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSEQ ";
	String SELECT_ONE_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD WHERE BOARDNO =? ";
	String INSERT_SQL = " INSERT INTO ANSWERBOARD VALUES (BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, 'N', ?, ?, ?, SYSDATE ) ";
	String UPDATE_SQL = " UPDATE ANSWERBOARD SET TITLE=?, CONTENT=? WHERE BOARDNO =? ";
	String DELETE_SQL = " UPDATE ANSWERBOARD SET DELFLAG ='Y' WHERE BOARDNO =? ";
	
	String ANSWER_UPDATE_SQL = 
			" UPDATE ANSWERBOARD SET "
			+ " GROUPSEQ = GROUPSEQ+1 "
			+ " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =? ) "
			+ " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =? ) ";
	String ANSWER_INSERT_SQL = 
			" INSERT INTO ANSWERBOARD "
			+ " VALUES ( "
			+ " BOARDNOSEQ.NEXTVAL, "
			+ " (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =? ),"
			+ " (SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO =? ),"
			+ " (SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO =? ),"
			+ " 'N', ?, ?, ?, SYSDATE )  ";
	
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int insert(AnswerDto dto);
	public int update(AnswerDto dto);
	public int delete(int boardno);
	
	public int answerUpdate(int parentboardno);
	public int answerInsert(AnswerDto dto);
	
	public int muldel(String[] boardno);
}


