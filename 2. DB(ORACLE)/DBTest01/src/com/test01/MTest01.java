package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Java DataBase Connection
		// 1. driver 연결 (ojbdc6.jar) : java와 database를 연결하기 위해서 오라클이 제공해주는 라이브러리
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="kh";
		String password="kh";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		/*﻿
		자바와 데이터베이스(오라클)를 연결해줄건데 연결할 때
		해당 데이터베이스가 어디에 저장되어있는지, 그 계정이 뭔지, 패스워드가 뭔지를 이용해서
		커넥션 객체를 만들어 준거야
		(전에는 마우스로 클릭클릭 해서 커넥션 해줬다면 지금은 코드를 이용해서 연결해주고 있는 것)
		 */
		
		// 3. query 준비
		String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP ";
		// 쿼리문을 쓸때는 무조건 문장 앞, 문장 뒤에 공백 한칸씩 넣어주기!
		// EMP 뒤에 ; 세미콜론을 안붙히는 이유는 세미콜론은 SQL PLUS 에서 이용하는 문법이기 때문이다.
		// 디비버나 이클립스에서 세미콜론 붙히면 오류난다.
		
		Statement stmt = connection.createStatement(); // 실행해서 결과를 리턴받는 객체
		// connection 객체가 stmt 객체(쿼리를 실행시켜주기 위한 것)를 만들어 줄거야
	
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql); // ->결과값을 리턴받아
		// executeQuery()을 이용해 어떤sql을 db에 전달할건지
		while(rs.next()) {
			System.out.printf("%5d %10s %10s %5d %11s %7.2f %7.2f %3d \n",
					
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString("JOB"), 
					rs.getInt("MGR"), 
					rs.getDate(5),
					rs.getDouble(6), // SAL의 type이 number(7,2) <- 실수여서 같이 type을 맞춰주어야 한다.
					rs.getDouble(7), 
					rs.getInt(8));
		}
		
		
		// 5. db 종료
		rs.close();
		stmt.close();
		connection.close();
	}
}
