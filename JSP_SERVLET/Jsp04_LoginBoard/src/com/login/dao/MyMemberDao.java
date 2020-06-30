package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.login.db.JDBCTemplate;
import com.login.dto.MyMemberDto;

public class MyMemberDao extends JDBCTemplate{
	// 공통기능 : login
	public MyMemberDto login(String myid, String mypw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMemberDto dto = null;
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE FROM MYMEMBER "
					+ " WHERE MYID =? AND MYPW=? "
					+ " AND MYENABLED =? "; 
		// MYENABELD Y - 가입되어있다, N - 탈퇴했다
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			pstm.setString(3, "Y");
			System.out.println("3. query 준비 : "+sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto = new MyMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return dto;
	}
	
	// 관리자(ADMIN) 기능 : 회원 전체 정보, 가입된 회원 정보, 회원 등급 조정
	public List<MyMemberDto> selectList(){
		Connection con = getConnection();
		PreparedStatement pstm= null;
		ResultSet rs = null;
		List<MyMemberDto> list = new ArrayList<MyMemberDto>();
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE FROM MYMEMBER ";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				MyMemberDto dto = new MyMemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm); 
		}
		return list;
	}
	
	public List<MyMemberDto> selectEnabeld() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyMemberDto> list = new ArrayList<MyMemberDto>();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, "
	            + " MYPHONE, MYEMAIL, MYENABLED, MYROLE "
	            + " FROM MYMEMBER "
	            + " WHERE MYENABLED = 'Y' "
	            + " ORDER BY MYNO ASC ";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				MyMemberDto dto = new MyMemberDto(rs.getInt(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return list;
	}
	
	public int updateUserRole(int myno, String myrole) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql =" UPDATE MYMEMBER SET MYROLE =? WHERE MYNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myrole);
			pstm.setInt(2, myno);
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
	
	// 유저(USER) 기능 : 아이디 중복체크 => 회원가입, 내 정보 조회, 내 정보 수정(주소, 전화번호, 이메일), 탈퇴
	public MyMemberDto idCheck(String myid) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMemberDto dto = new MyMemberDto();
		String sql = " SELECT MYID FROM MYMEMBER WHERE MYID =? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			System.out.println("3. query 준비 : "+sql);
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
			dto.setMyid(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return dto;
	}
	
	public boolean insertUser(MyMemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MYMEMBER VALUES (MYNOSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, 'Y', 'USER') ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyid());
			pstm.setString(2, dto.getMypw());
			pstm.setString(3, dto.getMyname());
			pstm.setString(4, dto.getMyaddr());
			pstm.setString(5, dto.getMyphone());
			pstm.setString(6, dto.getMyemail());

			
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
		
		return (res > 0)?true : false;
	}
	
	public MyMemberDto selectUser(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyMemberDto dto = new MyMemberDto();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, "
	            + " MYPHONE, MYEMAIL, MYENABLED, MYROLE "
	            + " FROM MYMEMBER "
	            + " WHERE MYNO =? ";
	    try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
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
	
	public int updateUser(MyMemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MYMEMBER SET MYPHONE=?, MYEMAIL=?, MYADDR=? WHERE MYNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyphone());
			pstm.setString(2, dto.getMyemail());
			pstm.setString(3, dto.getMyaddr());
			pstm.setInt(4, dto.getMyno());
			
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
	
	public int deleteUser(int myno) {
		// update : myenabled 'Y' -> 'N'
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		String sql = " UPDATE MYMEMBER SET MYENABLED='N' WHERE MYNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			result = pstm.executeUpdate();
			
			if(result > 0) {
				commit(con);
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
