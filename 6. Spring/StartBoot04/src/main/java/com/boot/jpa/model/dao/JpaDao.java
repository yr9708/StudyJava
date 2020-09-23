package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.model.dto.JpaDto;

@Repository
public interface JpaDao extends JpaRepository<JpaDto, Integer> {
	
	public List<JpaDto> findAll(); // jpaRepository에 있는 메소드 쓰는거라서 findAll로 써줘야함
	
	public JpaDto findByMyno(int myno);
	
	public JpaDto save(JpaDto dto); // int로 return 하지 않는 이유? JpaRepository에서 그렇게 만들어 놓음..영속성 때문인거 같은데 Jpa 자체가 객체 자체를 가지고 있어서 그렇다.
	
	public JpaDto saveAndFlush(JpaDto dto);
	
	@Transactional
	public void deleteByMyno(int myno);
}
