package com.mvc.update.model.dao;

import java.util.List;

import com.mvc.update.model.dto.JDBCDto;

public interface JDBCDao {
	
	String SELECTLIST = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
	String SELECTONE = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD WHERE SEQ=? ";
	String INSERT = " INSERT INTO JDBCBOARD VALUES (JDBCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE ) ";
	String UPDATE = " UPDATE JDBCBOARD SET WRITER=?, TITLE=?, CONTENT=? WHERE SEQ=? ";
	String DELETE = " DELETE JDBCBOARD WHERE SEQ=? ";
	
	public List<JDBCDto> selectList();
	public JDBCDto selectOne(int seq);
	public int insert(JDBCDto dto);
	public int update(JDBCDto dto);
	public int delete(int seq);
}
