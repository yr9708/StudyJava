package com.bike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bike.db.JDBCTemplate;
import com.bike.dto.BikeDto;

public class BikeDao extends JDBCTemplate{
	public int insertDb(List<BikeDto> list) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res =0;
		int[] cnt = null;
		
		String sql = " INSERT INTO BIKE_TB VALUES (?, ?, ?, ?, ?, ?, ?) ";
		try {
			pstm = con.prepareStatement(sql);
			for(int i =0; i<list.size(); i++) {
				pstm.setString(1,list.get(i).getAddr_gu());
				pstm.setInt(2, list.get(i).getContent_id());
				pstm.setString(3, list.get(i).getContent_nm());
				pstm.setString(4, list.get(i).getNew_addr());
				pstm.setInt(5, list.get(i).getCradle_count());
				pstm.setDouble(6, list.get(i).getLongitude());
				pstm.setDouble(7, list.get(i).getLatitude());
				
				pstm.addBatch();
			}
			
			cnt = pstm.executeBatch();
			
			for(int i =0; i<cnt.length; i++) {
				if(cnt[i] == -2) {
					res++;
				}
			}
			
			if(list.size() == res) {
				commit(con);
				System.out.println("commit");
			} else {
				rollback(con);
				System.out.println("rollback");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		
		return res; // (res == list.size()) ? 1 : 0;
	}
	
	public boolean delete() {
		Connection con = getConnection();
		Statement stmt = null;
		int res = 0;
		String sql = " DELETE FROM BIKE_TB ";
		
		try {
			stmt = con.createStatement();
			System.out.println("3. query 준비 : "+sql);
			res = stmt.executeUpdate(sql);
			System.out.println("4. query 실행 및 리턴");
			if(res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			System.out.println("[error] 3. 4");
			e.printStackTrace();
		}finally {
			close(stmt);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		return (res > 0)? true : false;
	}
	
	
}
