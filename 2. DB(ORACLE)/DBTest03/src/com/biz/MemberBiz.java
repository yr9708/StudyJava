package com.biz;

import java.util.List;

import com.dao.MemberDao;
import com.dto.MemberDto;

// Business Logic = 계산 (연산) / 처리
public class MemberBiz {
	private MemberDao dao = new MemberDao();
	
	public List<MemberDto> selectList(){
		// 계산 연산 처리할게 없어서 바로 리턴
		return dao.selectList();
	}
	
	public MemberDto selectOne(int m_no) {
		return dao.selectOne(m_no);
	}
	
	public int insert(MemberDto dto) {
		dto.setM_gender(dto.getM_gender().toUpperCase()); // 대문자로 바꿔주기
		return dao.insert(dto);
//		// 강사님 코드
//		MemberDto tmp = dto;
//		tmp.setM_gender(dto.getM_gender().toUpperCase());
//		return dao.insert(dto);
		
	}
	
	public int update(MemberDto dto) {
		dto.setM_gender(dto.getM_gender().toUpperCase()); // 대문자로 바꿔주기
		return dao.update(dto);
	}
	
	public int delete(int m_no) {
		return dao.delete(m_no);
	}
}
