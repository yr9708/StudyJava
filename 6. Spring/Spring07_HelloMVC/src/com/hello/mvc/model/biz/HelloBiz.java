package com.hello.mvc.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc.model.dao.HelloDao;

@Service
public class HelloBiz {
	
	// TODO : 06. Dao(@Reapository) ȣ��
	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		
		// TODO : 08. Biz���� return 
		return "Hello, " + dao.getHello();
	}
	
	
}
