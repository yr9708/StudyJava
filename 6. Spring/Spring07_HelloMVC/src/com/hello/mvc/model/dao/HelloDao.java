package com.hello.mvc.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	
	// TODO : 07 : Dao¿¡¼­ return
	public String getHello() {
		return "Spring";
	}
}
