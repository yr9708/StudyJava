package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;

public interface BoardBiz {
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insertBoard(BoardDto dto);
	public int updateBoard(BoardDto dto);
	public int deleteBoard(int myno);
}
