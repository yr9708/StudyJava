package com.mvc.complete.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.complete.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger log = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	
	@Override
	public List<BoardDto> selectListBoard() {
		List<BoardDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"selectListBoard");
		} catch (Exception e) {
			log.info("[ERROR] selectListBoard");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BoardDto selectOneBoard(int myno) {
		BoardDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOneBoard",myno);
		} catch (Exception e) {
			log.info("[ERROR] selectOneBoard");
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
			log.info("[ERROR] insertBoard");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateBoard(BoardDto dto) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"updateBoard",dto);
		} catch (Exception e) {
			log.info("[ERROR] updateBoard");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deleteBoard(int myno) {
		int res = 0;
		try {
			res = sqlSession.delete(NAMESPACE+"deleteBoard",myno);
		} catch (Exception e) {
			log.info("[ERROR] deleteBoard");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String transactionTest() {
		return null;
	}

}
