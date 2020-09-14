package com.mvc.complete.model.biz;

import com.mvc.complete.model.dto.MemberDto;

public interface MemberBiz {
	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);
}
