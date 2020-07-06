package com.dao;

import static com.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.dto.MyTestDto;

// DAO : Data Access Object
// db와 연결하는 역할'만' 수행
// 값을 가지고 오거나, 값을 저장하거나, 값을 수정하거나, 값을 삭제하는 역할
public class MyTestDao {
	public List<MyTestDto> selectList(){
		// 1, 2
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT MNO, MNAME, NICKNAME FROM MYTEST ORDER BY MNO ";
		
		List<MyTestDto> list = new ArrayList<MyTestDto>();
		
		try {
			// 3
			stmt=con.createStatement();
			
			// 4
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MyTestDto dto = new MyTestDto();
				dto.setMno(rs.getInt(1));
				dto.setMname(rs.getString(2));
				dto.setNickName(rs.getString(3));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 5
			close(rs);
			close(stmt);
			close(con);
		}
		
		
		return list;
	}
	
	
	
	public int insert(MyTestDto dto) {
		int result = 0;
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		//강사님 코드
		/*
		Statement stmt = null;
		String sql = " INSERT INTO MYTEST VALUES ("+dto.getMno() + ", '"+dto.getMname()+"', '"+dto.getNickName()+"')";
		try {
			stmt = con.createStatement();
			result = stmt.excuteUpdate(sql);
			
			if(result > 0){
				commit(con);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(stmt);
			close(con);
		}
		*/
		
		String sql = "INSERT INTO MYTEST VALUES (?, ?, ?) ";

		try {
			pstm = con.prepareStatement(sql);
	
			pstm.setInt(1,dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getNickName());
			
			result = pstm.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return result;
	}
	
	public int update(MyTestDto dto) {
		int result = 0;
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		String sql = " UPDATE MYTEST SET MNAME = ?, NICKNAME = ? WHERE MNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, dto.getMname());
			pstm.setString(2, dto.getNickName());
			pstm.setInt(3, dto.getMno());
			
			result = pstm.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return result;
	}
	
	public int delete(int mno) {
		int result = 0;
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " DELETE FROM MYTEST WHERE MNO = ? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
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
