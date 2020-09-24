package com.mvc.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.mongo.dto.ScoreMongoDto;

@Repository
public class ScoreMongoDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<ScoreMongoDto> findAll(){
											// 우리가 어떤 객체 타입에 값을 넣어서 리턴해줄거니? score라는 컬렉션을 찾아서 findAll 할건데 Dto라는 타입에 넣어서 리턴해
		List<ScoreMongoDto> list = mongoTemplate.findAll(ScoreMongoDto.class,"score");
		
		return list;
	}
}
