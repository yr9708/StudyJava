package com.mvc.complete.model.biz;

import java.util.List;

import com.mvc.complete.model.dto.BoardDto;

public interface BoardBiz {
	public List<BoardDto> selectListBoard();
	public BoardDto selectOneBoard(int myno);
	public int insertBoard(BoardDto dto);
	public int updateBoard(BoardDto dto);
	public int deleteBoard(int myno);
	public String transactionTest();
	
}
