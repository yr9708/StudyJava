package com.mvc.complete.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.complete.model.dto.MemberDto;
@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	Logger log = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto result = null;
		try {
			result = sqlSession.selectOne(NAMESPACE+"login",dto);
		} catch (Exception e) {
			log.info("[ERROR] login");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insert(MemberDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"insertMember",dto);
		} catch (Exception e) {
			log.info("[ERROR] insert");
			e.printStackTrace();
		}
		
		return res;
	}

}
