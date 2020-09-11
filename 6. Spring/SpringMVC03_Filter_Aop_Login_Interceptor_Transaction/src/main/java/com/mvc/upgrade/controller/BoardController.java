package com.mvc.upgrade.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto",dto);
		
		return "detail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertBoardForm(Model model) {
		return "insertform";
	}
	
	@RequestMapping("/insertboard.do")
	public String insertBoard(Model model, @ModelAttribute BoardDto dto) {
		int res = biz.insertBoard(dto);
		if(res > 0) {
			return "redirect:list.do";
		}else {
			return "redirect:insertform.do";
		}	
	}
	
	@RequestMapping("/updateform.do")
	public String updateBoardForm(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto",dto);
		
		return "updateform";
	}
	
	@RequestMapping("/updateboard.do")
	public String updateBoard(Model model, @ModelAttribute BoardDto dto) {
		int res = biz.updateBoard(dto);
		if(res>0) {
			
			return "redirect:list.do";
		}else {
			return "redirect:list.do";
			
		}
	}
	
	@RequestMapping("/deleteboard")
	public String deleteBoard(Model model, int myno) {
		int res = biz.deleteBoard(myno);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:list.do";
		}
	}
	
	@RequestMapping("/test.do")
	public String transactionTest() {
		logger.info("[test.do]");
		biz.transactionTest();
		
		return "redirect:list.do";
	}
}
