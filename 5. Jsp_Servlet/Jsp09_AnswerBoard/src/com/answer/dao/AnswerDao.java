package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.PagedResultsControl;

import com.answer.db.JDBCTemplate;
import com.answer.dto.AnswerDto;

public class AnswerDao extends JDBCTemplate{
	public List<AnswerDto> selectList(){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		String sql = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSEQ ";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				AnswerDto dto = new AnswerDto (
							rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8)					
						);
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return list;
	}
	
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT BOARDNO, TITLETAB, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD WHERE BOARDNO=? ";
		AnswerDto dto = new AnswerDto();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setboardno(rs.getInt(1));
				dto.settitletab(rs.getInt(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setWriter(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int insert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO ANSWERBOARD VALUES (BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, ?, ?, ?, SYSDATE ) ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	public int update(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE ANSWERBOARD SET TITLE=?, CONTENT=?, WRITER=? WHERE BOARDNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			pstm.setInt(4, dto.getboardno());
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	public int delete(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
	//	String sql = " DELETE FROM ANSWERBOARD WHERE BOARDNO =? ";
		String sql = " UPDATE ANSWERBOARD SET BOARDNO = 0 WHERE BOARDNO = ? ";
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	
	public int answerUpdate(int parentboardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE ANSWERBOARD "
				+ " SET GROUPSEQ = GROUPSEQ +1 "
				+ " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =? ) "
				+ " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =? ) ";        
        		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, parentboardno);
			pstm.setInt(2, parentboardno);
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	public int answerInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO ANSWERBOARD "
				+ " VALUES ( BOARDNOSEQ.NEXTVAL, "
				+ " (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =? ),"
				+ " (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =? )+1,"
				+ " (SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO =? )+1,"
				+ " ?, ?, ?, SYSDATE ) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getboardno());
			pstm.setInt(2, dto.getboardno());
			pstm.setInt(3, dto.getboardno());
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}
}




/*
 * 메소드 하나당 기능 1개 이기 때문에 이렇게 하면 안됨.
	public int insertAnswer(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		int res1 = 0;
		int res2 = 0;
		String sql1 = " UPDATE ANSWEBOARD "
				+ " SET GROUPSEQ = GROUPSEQ+1 "
				+ " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHRER BOARDNO =? "
				+ " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =? ";
		String sql2= " INSERT INTO ANSWERBOARD "
				+ " VALUES ( BOARDNOSEQ.NEXTVAL, "
				+ " (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =? ),"
				+ " (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =? )+1,"
				+ " (SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO =? )+1,"
				+ " TITLE =? , CONTENT =?, WRITER=?, SYSDATE ) ";
		try {
			pstm1 = con.prepareStatement(sql1);
			pstm1.setInt(1, dto.getboardno());
			pstm1.setInt(2, dto.getboardno());
			res1 = pstm1.executeUpdate();
			
			pstm2 = con.prepareStatement(sql2);
			pstm2.setInt(1, dto.getboardno());
			pstm2.setInt(2, dto.getboardno());
			pstm2.setInt(3, dto.getboardno());
			pstm2.setString(4, dto.getTitle());
			pstm2.setString(5, dto.getContent());
			pstm2.setString(6, dto.getWriter());
			res2 = pstm2.executeUpdate();
			
			if((res1 & res2) > 1) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm2);
			close(pstm1);
			close(con);
		}
		
		return res1+res2;
	}
*/	
	

