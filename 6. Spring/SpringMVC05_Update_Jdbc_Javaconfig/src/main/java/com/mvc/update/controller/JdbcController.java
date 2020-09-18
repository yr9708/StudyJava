package com.mvc.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JdbcBiz;

@Controller
public class JdbcController {

	@Autowired
	public JdbcBiz jdbcBiz;
	
	@RequestMapping("/jdbclist.do") // void면 requestMapping에 있는 이름으로 jsp를 읽어온다(jsp의 이름과 같아야함)
	public void selectList(Model model) {
		model.addAttribute("list",jdbcBiz.selectList());
	}
}
