package com.mvc.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JDBCBiz;
import com.mvc.update.model.dto.JDBCDto;

@Controller
public class JDBCController {
	@Autowired
	private JDBCBiz jdbcBiz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		model.addAttribute("list",jdbcBiz.selectList());
		return "jdbclist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int seq) {
		model.addAttribute("dto",jdbcBiz.selectOne(seq));
		return "detail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertform() {
		return "insertform";
	}
	
	@RequestMapping("/insert.do")
	public String insert(Model model, JDBCDto dto) {
		int res = jdbcBiz.insert(dto);
		if(res > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:insertform.do";
	}
	
	@RequestMapping("/updateform.do")
	public String updateform(Model model,int seq) {
		model.addAttribute("dto",jdbcBiz.selectOne(seq));
		return "updateform";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model, JDBCDto dto) {
		int res = jdbcBiz.update(dto);
		if(res > 0) {
			return "redirect:detail.do?seq="+dto.getSeq();
		}
		return "redirect:updateform.do?seq="+dto.getSeq();
	}
	
	@RequestMapping("/delete.do")
	public String delete(int seq) {
		int res = jdbcBiz.delete(seq);
		if(res>0) {
			return "redirect:list.do";
		}
		return "redirect:detail.do?seq="+seq;
	}
}
