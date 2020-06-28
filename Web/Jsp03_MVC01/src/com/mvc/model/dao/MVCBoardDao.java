package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.db.JDBCTemplate;
import com.mvc.model.dto.MVCBoardDto;

public class MVCBoardDao extends JDBCTemplate{
	public List<MVCBoardDto> selectList(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		System.out.println("3. query 준비");
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD ";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("4. quety 실행 및 리턴");
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("5. db종료");
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;
	}
	
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD WHERE SEQ=? ";
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			System.out.println("3. query 준비");
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,seq);
			
			System.out.println("4. query 실행 및 리턴");
			rs = pstm.executeQuery();
			if(rs.next()) {
			dto.setSeq(rs.getInt(1));
			dto.setWriter(rs.getString(2));
			dto.setTitile(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("[error] 3. 4. ");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db종료");
		}
		
		return dto;
	}
	
	public int insert(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		String sql = " INSERT INTO MVCBOARD VALUES (MVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return result;
	}
	
	public int update(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		
		String sql = " UPDATE MVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			result = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
	
		return result;
	}
	
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " DELETE FROM MVCBOARD WHERE SEQ=? ";
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
}
