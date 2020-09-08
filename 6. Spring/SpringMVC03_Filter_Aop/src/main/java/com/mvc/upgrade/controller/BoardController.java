package com.mvc.upgrade.controller;

import java.util.List;

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
	private BoardBiz boardBiz;
	
	@RequestMapping(value="list.do")
	public String selectList(Model model) {
		List<BoardDto> list = boardBiz.selectList();
		model.addAttribute("list",list);
		
		return "mvclist";
	}
	
	@RequestMapping(value="insertform.do")
	public String insertForm(Model model) {
		
		return "insertform";
	}
	
	@RequestMapping(value="insert.do")
	public String insert(Model model, @ModelAttribute BoardDto dto) {
		int res = boardBiz.insert(dto);
		if(res > 0) {
			List<BoardDto> list = boardBiz.selectList();
			model.addAttribute("msg","작성되었습니다");
			return "redirect:list.do";
		}else {
			model.addAttribute("msg","작성 실패");
			return "insertform";
		}
	}
	
	@RequestMapping(value="selectOne.do")
	public String selectOne(Model model, int myno) {
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto",dto);
		return "detail";
	}
	
	@RequestMapping(value="updateform.do")
	public String updateForm(Model model, int myno) {
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto",dto);
		return "updateform";
	}
	
	@RequestMapping(value="update.do")
	public String update(Model model, @ModelAttribute BoardDto dto) {
		int res = boardBiz.update(dto);
		if(res > 0) {
			model.addAttribute("msg","수정 완료되었습니다.");
			model.addAttribute("dto",dto);
			return "detail";
		}else {
			model.addAttribute("msg","수정 실패");
			model.addAttribute("dto",dto);
			return "updateform";
		}
	}
	
	@RequestMapping(value="delete.do")
	public String delete(Model model, int myno) {
		int res = boardBiz.delete(myno);
		if(res > 0) {
//			model.addAttribute("msg","삭제되었습니다");
//			List<BoardDto> list = boardBiz.selectList();
//			model.addAttribute("list",list);
			return "redirect:list.do";
		}else {
//			model.addAttribute("msg","삭제실패");
//			BoardDto dto = boardBiz.selectOne(myno);
//			model.addAttribute("dto",dto);
			return "redirect:selectOne.do?myno="+myno;
		}
	}
	
	
	
}
