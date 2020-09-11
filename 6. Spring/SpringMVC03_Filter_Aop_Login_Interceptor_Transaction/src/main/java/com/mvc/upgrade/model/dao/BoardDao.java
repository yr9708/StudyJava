package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;

public interface BoardDao {
	String NAMESPACE = 	"com.myboard.";
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insertBoard(BoardDto dto);
	public int updateBoard(BoardDto dto);
	public int deleteBoard(int myno);
	
	public String test();
}
