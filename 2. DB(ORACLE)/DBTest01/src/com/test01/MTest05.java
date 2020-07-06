package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MTest05 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// DELETE
		
		// 1. driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="kh";
		String password="kh";
		Connection con = DriverManager.getConnection(url,user,password);
		
		// 3. query 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("input the number for delete");
		int mno = sc.nextInt();
		String sql =" DELETE FROM MYTEST WHERE MNO = ? ";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, mno); // 해당 ? 물음표에 값을 넣어서 미리 쿼리문을 만들어 놓는것
		/*
		 * Statement stmt = con.createStatement();
		 * String sql = "DELETE FROM MTTEST WHERE MNO = ? " +mno;
		 */
		// 4. query 실행 및 리턴
		int res = pstm.executeUpdate();
		/*
		 * int res = stmt.executeUpdate(sql);
		 */
		if(res> 0) {
			System.out.println("delete success");
		}
		
		// 5. db 종료
		pstm.close();
		con.close();
		
		
	}
}
