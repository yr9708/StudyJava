package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {
	@Autowired
	private MyBiz myBiz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list",myBiz.selectList());
		return "bootlist";
	}
	
	
	@GetMapping("/detail")
	public String selecOne(Model model, int myno) {
		model.addAttribute("dto",myBiz.selectOne(myno));
		return "detail";
	}
	
	@GetMapping("insertform")
	public String insertForm() {
		return "insertform";
	}
	
	@GetMapping("insert")
	public String insert(Model model, MyDto dto) {
		int res = myBiz.insert(dto);
		if(res>0) {
			return "redirect:list";
		}
		return "rediret:insertform";
		
	}
	
	@GetMapping("updateform")
	public String updateform(Model model,int myno) {
		model.addAttribute("dto",myBiz.selectOne(myno));
		return "updateform";
	}
	
	@GetMapping("update")
	public String update(Model model, MyDto dto) {
		int res = myBiz.update(dto);
		if(res>0) {
			return "redirect:detail?myno="+dto.getMyno();
		}
		return "redirect:detail?myno="+dto.getMyno();
	}
	
	@GetMapping("delete")
	public String delete(int myno) {
		int res = myBiz.delete(myno);
		if(res>0) {
			return "redirect:list";
		}
		return "redriect:detail?myno="+myno;
	}
}
