package com.mvc.update.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<JDBCDto> selectList() {
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		/*
		 * list = jdbctemplate.query(SELECTLIST, new MyMapper());
		 */		
		
		// lambda : java 1.8 부터 가능 , 1회용으로 간단하게 사용하기 위해서 씀
		list = jdbctemplate.query(SELECTLIST,(rs,rowNum) ->{
			JDBCDto dto = new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			return dto;
		});
		return list;
	}

	@Override
	public JDBCDto selectOne(int seq) {
		JDBCDto dto =  (JDBCDto) jdbctemplate.queryForObject(SELECTONE, new Object[]{seq}, new MyMapper());

		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		int res = jdbctemplate.update(INSERT, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()});
		return res;
	}

	@Override
	public int update(JDBCDto dto) {
		int res = jdbctemplate.update(UPDATE, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent(), dto.getSeq()});
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = jdbctemplate.update(DELETE, new Object[] {seq});
		return res;
	}
	
	//inner Class 
	private static final class MyMapper implements RowMapper<JDBCDto>{

		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}

}
