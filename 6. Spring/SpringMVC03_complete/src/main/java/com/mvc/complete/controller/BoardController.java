package com.mvc.complete.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.complete.model.biz.BoardBiz;
import com.mvc.complete.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz biz;
	
	Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("selectList.do")
	public String selectListBoard(Model model) {
		log.info("[BoardController] : selectList");
		List<BoardDto> list = biz.selectListBoard();
		model.addAttribute("list",list);
		return "boardlist";
	}
	
	@RequestMapping("selectOne.do")
	public String selectOneBoard(Model model,int myno) {
		log.info("[BoardController] : selectOne");

		BoardDto dto = biz.selectOneBoard(myno);
		model.addAttribute("dto",dto);
		return "boardone";
	}
	
	@RequestMapping("insertForm.do")
	public String insertBoardForm() {
		log.info("[BoardController - insertForm]");

		return "insertform";
	}
	
	@RequestMapping("insertBoard.do")
	public String insertBoard(Model model, @ModelAttribute BoardDto dto) {
		log.info("[BoardController] : insertBoard");

		int res = biz.insertBoard(dto);
		if(res > 0) {
			log.info("글작성 성공");
			return "redirect:selectList.do";
		}else {
			log.info("글작성 실패");
			return "refirect:insertform.do";
		}
	}
	
	@RequestMapping("updateForm.do")
	public String updateBoardForm(Model model,int myno) {
		log.info("[BoardController] : updateForm");

		BoardDto dto = biz.selectOneBoard(myno);
		model.addAttribute("dto",dto);
		return "updateform";
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(Model model, @ModelAttribute BoardDto dto) {
		log.info("[BoardController] : updateBoard");

		int res = biz.updateBoard(dto);
		if(res>0) {
			log.info("글수정 성공");
			return "redirect:selectOne.do?myno="+dto.getMyno();
		}else {
			log.info("글수정 실패");
			return "redirect:updateform";
		}
	}
	
	@RequestMapping("deleteBoard")
	public String deleteBoard(Model model,int myno) {
		log.info("[BoardController] : deleteBoard");

		int res = biz.deleteBoard(myno);
		if(res>0) {
			log.info("글삭제 성공");
			return "redirect:selectList.do";
		}else {
			log.info("글삭제 실패");
			return "redirect:selectOne.do?myno="+myno;
		}
	}
	
	@RequestMapping("/transactionTest.do")
	public String transactionTest() {
		log.info("[BoardController] : transactionTest");
		biz.transactionTest();
		
		return "redirect:seletList.do";
	}
}
