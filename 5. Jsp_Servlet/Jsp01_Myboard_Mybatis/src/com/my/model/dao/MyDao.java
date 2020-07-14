package com.my.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.model.db.SqlMapConfig;
import com.my.model.dto.MyDto;

public class MyDao extends SqlMapConfig{
	
	private String namespace ="myboard.";
	
	public List<MyDto> selectList() {
		SqlSession session = null;
		List<MyDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			// sqlSessionFactory 객체 생성, session이 열림 true/false가 뭔가? 
			list = session.selectList("myboard.selectList"); // myboard라는 mapper에서 selectList를 찾아서 리턴해
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		
		return list;
	}

	public MyDto selectOne(int myno) {
		SqlSession session = null;
		MyDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne",myno);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dto;
	}

	public int insert(MyDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insertDto", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

	public int update(MyDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"updateDto", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

	public int delete(int myno) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

}
