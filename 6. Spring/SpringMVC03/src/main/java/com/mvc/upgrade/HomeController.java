package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value="/list.do")
	public String selectList(Model model) {
		System.out.println("[SELECT LIST]");
		
		model.addAttribute("list",biz.selectList());
		
		return "mvclist";
	}
	
	@RequestMapping(value="/insertform.do")
	public String insertForm(Model model) {
		System.out.println("[INSERT FORM]");
		
		return "insertform";
	}
	
	@RequestMapping(value="insert.do")
	public String insert(Model model, @ModelAttribute BoardDto dto) {
		System.out.println("[INSERT]");
		
		int res = biz.insert(dto);
		if(res>0) {
			model.addAttribute("msg","등록되었습니다");
			model.addAttribute("list",biz.selectList());
			return "mvclist";
		}else {
			return "insertform";
		}
	}
	
	@RequestMapping(value="selectOne.do")
	public String selectOne(Model model, int myno) {
		System.out.println("[SELECT ONE]");
		
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto",dto);
		
		return "selectOne";
		
	}
	
	@RequestMapping(value="updateform.do")
	public String updateForm(Model model, int myno) {
		System.out.println("[UPDATE FORM]");
		
		model.addAttribute("dto",biz.selectOne(myno));
	
		return "updateform";
	}
	
	@RequestMapping(value="update.do")
	public String update(Model model, @ModelAttribute BoardDto dto) {
		System.out.println("[UPDATE]");
		
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("msg","수정 되었습니다");
			model.addAttribute("dto",biz.selectOne(dto.getMyno()));
			return "selectOne";
		}else {
			model.addAttribute("msg","수정 실패");
			model.addAttribute("dto",dto);
			return "updateform";
		}
	}
	
	@RequestMapping(value="delete.do")
	public String delete(Model model, int myno) {
		System.out.println("[DELETE]");
			
		int res = biz.delete(myno);
		if(res > 0) {
			model.addAttribute("list",biz.selectList());
			model.addAttribute("msg","삭제 되었습니다");
			return "mvclist";
		}else {
			model.addAttribute("msg","삭제 실패");
			model.addAttribute("dto",biz.selectOne(myno));
			return "selectOne";
		}
		
	}
}
