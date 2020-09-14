package com.mvc.complete.model.dao;

import com.mvc.complete.model.dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "memberMapper.";

	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);
}
