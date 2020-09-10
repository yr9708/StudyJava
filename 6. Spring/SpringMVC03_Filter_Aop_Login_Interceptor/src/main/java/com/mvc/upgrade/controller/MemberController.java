package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		return "loginform";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		logger.info("[ajaxlogin.do]");
		
		
		MemberDto res = biz.login(dto);
		boolean bl = false;
		
		if(res!=null) {
			bl = true;
			session.setAttribute("memberDto", res);
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check",bl);
		
		return map;
	}
	
}
