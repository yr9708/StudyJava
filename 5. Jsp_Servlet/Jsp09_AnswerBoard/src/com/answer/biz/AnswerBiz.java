package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;

public class AnswerBiz {
	
	AnswerDao dao = new AnswerDao();
	
	public List<AnswerDto> selectList(){
		return dao.selectList();
	}
	
	public AnswerDto selectOne(int boardno) {
		return dao.selectOne(boardno);
	}
	
	public int insert(AnswerDto dto) {
		return dao.insert(dto);
	}
	
	public int update(AnswerDto dto) {
		return dao.update(dto);
	}
	
	public int delete(int boardno) {
		return dao.delete(boardno);
	}
	
	public int answerProc(AnswerDto dto) {
		// 원래는 트랜잭션(DB에서 최소한의 작업단위) 처리해줘야함
		// update할 갯수가 있으면 update를 해라. 먼저 계산해주는게 맞다
		int update = dao.answerUpdate(dto.getboardno());
		int insert = dao.answerInsert(dto);
		
		return update+insert;
	}
}
