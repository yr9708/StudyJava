package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DB 연결, 연결 해제, 저장, 취소
// static 으로 만들자.
public class JDBCTemplate {
	public static Connection getConnection() {
		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[ERROR] 1. driver 연결");
			e.printStackTrace();
		}
		
		// 2. 계정 연결
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="kh";
		String password="kh";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false); 
			// setAutoCommit 을 사용하지 않으면 default 값은 true(자동으로 commit) 다
			// setAutoCommit을 사용해주면 내가 원할때 저장되게 할 수 있다.
		} catch (SQLException e) {
			System.out.println("[ERROR] 2. 계정 연결");
			e.printStackTrace();
		}

		return con;
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) { 
		
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		// prerparedStatment는 Statement를 상속받아서 만들어진 객체이기 때문에
		// 부모 객체가 불러와지면 굳이 따로 만들어주지 않아도 닫을 수 있다.
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
