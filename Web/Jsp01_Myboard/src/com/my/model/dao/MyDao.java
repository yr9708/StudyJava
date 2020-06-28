package com.my.model.dao;

import static com.my.model.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.model.dto.MyDto;

public class MyDao {
	public List<MyDto> selectList(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MyDto> list = new ArrayList<MyDto>();
		
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYDATE FROM MYBOARD ";
		
		try {
			System.out.println("3. 4. 쿼리 실행 ");
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MyDto dto = new MyDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMydate(rs.getDate(4));
				
				list.add(dto);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[error] 4. ");
		} finally {
			System.out.println("5. db 종료");
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;
	}
	
	public MyDto selectOne(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MyDto dto = new MyDto();
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD WHERE MYNO=? ORDER BY MYNO DESC ";
		
		try {
			System.out.println("3.4. 쿼리 준비 및 실행");
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));
			}

		} catch (SQLException e) {
			System.out.println("[error] 3. 4.");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return dto;
	}
	
	public int insert(MyDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		
		String sql = " INSERT INTO MYBOARD VALUES (MYNOSEQ.NEXTVAL, ?, ?, ?, SYSDATE ) ";
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			
			result = pstm.executeUpdate();
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return result;
	}
	
	
	public int update(MyDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		
		String sql = " UPDATE MYBOARD SET MYTITLE=?, MYCONTENT=? WHERE MYNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			con.setAutoCommit(false);
			
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			
			result = pstm.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return result;
	}
	
	public int delete(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		
		String sql = " DELETE FROM MYBOARD WHERE MYNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			con.setAutoCommit(false);
			
			pstm.setInt(1, myno);
			result = pstm.executeUpdate();
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		
		return result;
	}
	
}
