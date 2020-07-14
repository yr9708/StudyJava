package com.muldel.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.muldel.dto.MDBoardDto;

public class MDBoardDao extends SqlMapConfig{
	
	private String namespace ="com.muldel.mapper.";
	
	public List<MDBoardDto> selectList() {
		SqlSession session = null;
		List<MDBoardDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return list;
	}

	public MDBoardDto selectOne(int seq) {
		SqlSession session = null;
		MDBoardDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne",seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	
		return dto;
	}

	public int insert(MDBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

	public int update(MDBoardDto dto) {
		SqlSession session =  null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"update",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return res;
	}

	public int delete(int seq) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"delete",seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return res;
	}

	public int multiDelete(String[] seq) { 
		
		return 0; // (seq.length == res)? 1:0; 모두 다 삭제되었을때만 1이나오고 아니면 0이 나옴
	}
}
