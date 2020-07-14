package com.mudel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.muldel.db.JDBCTemplate;
import com.muldel.dto.MVCBoardDto;

public class MVCBoardDao extends JDBCTemplate{
	public List<MVCBoardDto> selectList(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD ORDER BY SEQ DESC ";
		
		try {
			stmt = con.createStatement();
			System.out.println("3. query 준비");
			
			rs = stmt.executeQuery(sql);
			System.out.println("4 query 실행 및 리턴");
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				
				list.add(dto);
			
			}
		} catch (SQLException e) {
			System.out.println("[error] 3. 4.");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("5. db 종료");
		} 
		
		return list;
	}
	
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD WHERE SEQ=? ";
		MVCBoardDto dto = new MVCBoardDto();
		
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
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}
	
	
	public int insert(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int result = 0;
				
		String sql = " INSERT INTO MDBOARD VALUES ( MDBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE ) ";
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
		
		String sql = " UPDATE MDBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			System.out.println("오케이 확인 "+dto.getContent()+dto.getTitle()+dto.getSeq());
			
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
		int result = 0;
		
		String sql = " DELETE FROM MDBOARD WHERE SEQ=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			result = pstm.executeUpdate();
			if(result > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int multiDelete(String[] seq) { // 데이터에서 넘어오는 값이 문자열이기 때문에 String 배열로 사용해줌 
											//int[] 쓰고 싶으면 jsp단에서 parseInt해줘서 넘겨야함.
		// ["1", "2", "3"...]
		
		// 객체가 삭제하는 속도보다 con 객체가 연결되어 있는 숫자가 더 많으면 connection pool이 꽉 찰거야
		// 그래서 더 사용 할 수 없다고 에러가 날꺼야
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM MDBOARD WHERE SEQ =? ";
		int[] cnt = null;
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i =0; i<seq.length; i++) {
				pstm.setString(1, seq[i]);
				// 메모리의 적재 후, executeBatch() 메소드가 호출 될 때 한번에 실행
				// -> 메모리에 잠깐 넣어두고 addBatch() (모아놨다가) executeBatch()가 되면 모아둔것이 다 실행 됨.
				pstm.addBatch();
				System.out.println("삭제할 번호 : " + seq[i]);
			}
			System.out.println("3. query 준비 : " + sql);
			
			cnt = pstm.executeBatch();
			System.out.println("4. query 실행 및 리턴");
			
			
			// 성공 : -2 , 실패 : -3
			// executeBatch가 성공하면 SUCCESS_NO_INFO라는 상수값을 반환하는데 그게 값이 -2 
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i] == -2) {
					res++;
				}
			}
			
			if(seq.length == res) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("[error] 3. 4. ");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		return res; // (seq.length == res)? 1:0; 모두 다 삭제되었을때만 1이나오고 아니면 0이 나옴
	}
}
