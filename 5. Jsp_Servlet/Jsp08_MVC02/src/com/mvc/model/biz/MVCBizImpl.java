package com.mvc.model.biz;

import java.util.List;

import com.mvc.model.dao.MVCDao;
import com.mvc.model.dao.MVCDaoImpl;
import com.mvc.model.dto.MVCDto;

public class MVCBizImpl implements MVCBiz {
	
	private MVCDao dao = new MVCDaoImpl();

	@Override
	public List<MVCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MVCDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MVCDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

}
