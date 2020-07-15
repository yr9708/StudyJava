package com.muldel.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.muldel.dto.MDBoardDto;

public class MDBoardDao extends SqlMapConfig{
	
	private String namespace ="com.muldel.mapper.";
	
	public List<MDBoardDto> selectList() {
		SqlSession session = null;
		List<MDBoardDto> list = null;
		
		try {
			// auto commit 할거야 안할거야?, 기본값은 true
			session = getSqlSessionFactory().openSession(false);
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
			session = getSqlSessionFactory().openSession(false);
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
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert",dto);
			if(res > 0) {
				session.commit();
			}
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
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"update",dto);
			if(res > 0) {
				session.commit();
			}
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
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"delete",seq);
			if(res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return res;
	}

	public int multiDelete(String[] seq) { 
		int count = 0;
		Map<String, String[]> map = new HashMap<>();
		map.put("seqs",seq);
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession(false);
			count =session.delete(namespace+"muldel",map);
			if(count==seq.length) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count; 
	}
}
