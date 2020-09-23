package com.boot.jpa.controller;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.dto.JpaDto;

@Controller
@RequestMapping("/member")
public class JpaController {
	
	@Autowired
	private JpaDao jpaDao;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list",jpaDao.findAll());
		
		return "jpalist";
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int myno) {
		model.addAttribute("dto",jpaDao.findByMyno(myno));
		
		return "detail";
	}
	
	@GetMapping("/insertform")
	public String insertform() {
		return "insertform";
	}
	
	@PostMapping("/insert")
	public String insert(JpaDto dto) {
		dto.setMydate(new Date());
		jpaDao.save(dto);
		
		return "redirect:list";
		
	}
	
	@GetMapping("/updateform")
	public String updateform(Model model,int myno) {
		model.addAttribute("dto",jpaDao.findByMyno(myno));
		
		return "updateform";
	}
	
	@PostMapping("/update")
	@Transactional
	public String update(Model model, JpaDto dto) {
		jpaDao.saveAndFlush(dto);
		
		
		return "redirect:detail?myno="+dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		jpaDao.deleteByMyno(myno);
		
		return "redirect:list";
	}
	
}
