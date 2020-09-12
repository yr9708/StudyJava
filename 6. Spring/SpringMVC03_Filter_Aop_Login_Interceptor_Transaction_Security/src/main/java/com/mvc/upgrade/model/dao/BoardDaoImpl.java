package com.mvc.upgrade.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne",myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insertBoard(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"insertBoard",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateBoard(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"updateBoard",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteBoard(int myno) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"deleteBoard",myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String test() {
		return null;
	}

}
