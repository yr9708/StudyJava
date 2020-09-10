package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
