package com.test01;

import static com.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MTest06 {
	public static void main(String[] args) {
		// 1.
		
		// update
		Connection con = getConnection();
						// 위에 import를 안해주면 이런식으로 사용해야함 Connection con = JDBCTemplate.getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql =" UPDATE MYTEST SET MNAME =?, NICKNAME =? WHERE MNO=?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 번호 : ");
		int mno = sc.nextInt();
		System.out.println("수정될 이름 : ");
		String mname = sc.next();
		System.out.println("수정될 별명 : ");
		String nickName = sc.next();
		
	
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setString(1, mname);
			pstm.setString(2,nickName);
			pstm.setInt(3, mno);
			
			// 4.
			res = pstm.executeUpdate();
			if(res>0) {
				System.out.println("수정 성공");
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[ERROR] 3. or 4");
		} finally {
			close(pstm);
			close(con);
		}
		
		
		
	}
}
