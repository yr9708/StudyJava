package com.mvc.update.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JdbcDto;

@Repository
public class JdbcDaoImpl implements JdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<JdbcDto> selectList() {
		List<JdbcDto> list = new ArrayList<JdbcDto>();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
		
		try {
			list = jdbcTemplate.query(sql, (rs, rowNum)->{
				return new JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5));
			});
		} catch (DataAccessException e) {
			System.out.println("[Error] : selectList");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public JdbcDto selectOne(int seq) {
		return null;
	}

	@Override
	public int insert(JdbcDto dto) {
		return 0;
	}

	@Override
	public int update(JdbcDto dto) {
		return 0;
	}

	@Override
	public int delete(int seq) {
		return 0;
	}

}
