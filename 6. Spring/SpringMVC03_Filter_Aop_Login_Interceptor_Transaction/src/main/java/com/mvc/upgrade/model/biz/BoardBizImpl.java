package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz{
	
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
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
		dao.insertBoard(new BoardDto(0, "transaction","test","insert",null));
		
		String test = dao.test();
		// NullPointerException Error 발생! , 얘가 예외가 발생이 되면 위에 넣은 insertBoard도 취소가되야한다.
		test.length();
		
		
		return test;
	}

}
