package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.db.JDBCTemplate;
import com.mvc.model.dto.MVCBoardDto;

public class MVCBoardDao extends JDBCTemplate{
	public List<MVCBoardDto> selectList(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD ";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto(
							rs.getInt(1),
							rs.getString(2), 
							rs.getString(3), 
							rs.getString(4),
							rs.getDate(5));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,rs,stmt);
		}
		
		return list;
	}
	
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = new MVCBoardDto();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD WHERE SEQ=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,rs,pstm);
		}
		return dto;
	}
	
	public int insert(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MVCBOARD VALUES (MVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			res = pstm.executeUpdate();
			if(res > 0) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,pstm);
		}
		
		return res;
	}
	
	public int update(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			res = pstm.executeUpdate();
			if(res > 0) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,pstm);
		}
		return res;
		
	}
	
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " DELETE FROM MVCBOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			res = pstm.executeUpdate();
			if(res > 0) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		
		return res;
	}
}
