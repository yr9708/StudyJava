package com.mvc.complete.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.complete.model.dao.BoardDao;
import com.mvc.complete.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectListBoard() {
		return dao.selectListBoard();
	}

	@Override
	public BoardDto selectOneBoard(int myno) {
		return dao.selectOneBoard(myno);
	}

	@Override
	public int insertBoard(BoardDto dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int updateBoard(BoardDto dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public int deleteBoard(int myno) {
		return dao.deleteBoard(myno);
	}

	@Transactional
	@Override
	public String transactionTest() {
		dao.insertBoard(new BoardDto(0, "트랜잭션", "트랜잭", "션", null));
		String test = dao.transactionTest();
		test.length();
		return test;
	}

}
