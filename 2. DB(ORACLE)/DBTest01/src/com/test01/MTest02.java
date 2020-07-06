package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. driver 연결 (ojbdc6.jar) 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결 
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		// 3. query 준비
		
		String sql = " SELECT DEPTNO, DNAME, LOC FROM DEPT ";
		Statement stmt = connection.createStatement();
		
		// 4. query 실행 및 리턴
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.printf("%5d %10s %10s\n",
				rs.getInt(1),
				rs.getString(2),
				rs.getString("LOC")
				);
		}
		rs.close();
		stmt.close();
		connection.close();
	}
}

