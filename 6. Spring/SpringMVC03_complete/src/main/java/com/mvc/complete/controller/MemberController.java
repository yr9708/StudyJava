package com.mvc.complete.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.complete.model.biz.MemberBiz;
import com.mvc.complete.model.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz biz;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "loginform";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		log.info("[MemberController] ajaxlogin");
		MemberDto res = biz.login(dto);
		
		boolean check = false;
		if(res != null) {
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				log.info("입력된 pw : "+dto.getMemberpw());
				log.info("변환된 pw : "+res.getMemberpw());
				check = true;
				session.setAttribute("login", res);
			}
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check",check);
		
		return map;
	}
	
	@RequestMapping("/registForm.do")
	public String registform() {
		log.info("[MemberController] registform");
		return "registform";
	}
	
	@RequestMapping("/registRes.do")
	public String registMember(MemberDto dto) {
		log.info("[MemberController] registres");
		
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		if(biz.insert(dto) > 0) {
			return "redirect:loginForm.do";
		}
		
		return "redirect:registForm.do";
	}
}
