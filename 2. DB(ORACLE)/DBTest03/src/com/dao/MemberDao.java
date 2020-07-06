package com.dao;

import static com.db.JDBCTemplate.*;
import static com.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.MemberDto;
// Data Access Object : 데이터 베이스랑 연결
public class MemberDao {
	// 전체 출력
	public List<MemberDto> selectList(){
		Connection con = getConnection();
		Statement stmt = null;
		String sql = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL FROM TB_MEMBER ";
		
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberDto dto = new MemberDto(); // while문 안에 dto객체 생성하는 것과 while 바깥에 생성하는 것과의 차이?
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;
	}
	
	// 선택 출력
	public MemberDto selectOne(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null; // 테이블이 리턴될거야
	
		String sql = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL FROM TB_MEMBER WHERE M_NO = ? ";
		MemberDto dto = new MemberDto();
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, m_no);
			rs = pstm.executeQuery();
			
			while(rs.next()) { // 꼭 while 을 사용하지 않아도 된다. 결과값은 1row만 나오기 때문에
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}
	
	// 추가
	public int insert(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
	
		String sql = " INSERT INTO TB_MEMBER VALUES (MEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ? ) ";
		int result = 0; 
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			
			result = pstm.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 수정
	public int update(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		String sql = " UPDATE TB_MEMBER SET M_NAME =?, M_AGE =?, M_GENDER=?, M_LOCATION=?, "
				+ "M_JOB=?, M_TEL=?, M_EMAIL=? WHERE M_NO=? ";
		int result = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			pstm.setInt(8, dto.getM_no());
			
			result = pstm.executeUpdate();
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstm);
			close(con);
		}	
		return result;
	}
	
	// 삭제
	public int delete(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		
		String sql = " DELETE FROM TB_MEMBER WHERE M_NO = ? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_no);
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
