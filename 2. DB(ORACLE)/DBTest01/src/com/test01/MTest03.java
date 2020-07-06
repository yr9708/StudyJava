package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//insertSql();
		insertPreSql();
		selectSql();
		
	}
	
	public static void insertPreSql() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = " INSERT INTO MYTEST VALUES (? ,? ,?) ";
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		int mno = sc.nextInt();
		System.out.println("이름 입력 : ");
		String mname = sc.next();
		System.out.println("별명 입력 : ");
		sc.nextLine(); // 위의 토큰들을 버려버리고, 밑에 별명에 공백 포함해서 받고 싶을 때
		String nickName=sc.nextLine();
		
		
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, mno);
		pstm.setString(2, mname);
		pstm.setString(3, nickName);
		
		int res = pstm.executeUpdate();
		if(res > 0) {
			System.out.println("INSERT SUCCESS");
		}
		
		pstm.close();
		con.close();
		
		
	}
	
	public static void selectSql() throws ClassNotFoundException, SQLException {
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="kh";
		String password ="kh";
		Connection con = DriverManager.getConnection(url,user,password);
		
		Statement stmt = con.createStatement(); // sql문이랑 순서가 바뀌어도 상관없다.
		// 3. query 준비
		String sql = " SELECT MNO, MNAME, NICKNAME FROM MYTEST ORDER BY 1 ";
		
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
//			System.out.printf("%3d %5s %5s\n",
//					rs.getInt(1),
//					rs.getString(2),
//					rs.getString(3));
			System.out.println(rs.getInt(1)+" "+rs.getString("MNAME")+" "+rs.getString(3));
		}
		
		// 5. db종료
		rs.close();
		stmt.close();
		con.close();
	}
	
	public static void insertSql() throws ClassNotFoundException, SQLException{
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password ="kh";
		Connection con = DriverManager.getConnection(url,user,password);
		
		// 3. query 준비
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		int mno = sc.nextInt();
		System.out.println("이름 입력 : ");
		String mname = sc.next();
		System.out.println("별명 입력 : ");
		String nickName=sc.next();
		
		String sql = " INSERT INTO MYTEST VALUES (" + mno + ", '" + mname + "' , '" + nickName + "') ";
		
		// 4. query 실행 및 리턴
		int res = stmt.executeUpdate(sql); 
		// insert, update, delete 는 몇개의 row가 성공했다 라고 보기 위해서 리턴타입이 int 이다.
		if(res>0) {
			System.out.println(res+"row insert success");
			
		}
		
		// 5. db 종료
		stmt.close();
		con.close();
		
	}
}
