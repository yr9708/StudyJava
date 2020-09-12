package com.mvc.upgrade.controller;

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

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz biz;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
			//rawPassword : 입력된 값, encodedPassword : DB에 암호화된 값
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				logger.info("사용자가 전달한 memberpw : "+dto.getMemberpw());
				logger.info("DB에 암호화 되어 저장된 memberpw : " + res.getMemberpw());
				bl = true;
				session.setAttribute("login", res);
				
			}
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check",bl);
		
		return map;
	}
	
	@RequestMapping("/registform.do")
	public String registform() {
		logger.info("registform.do");
		
		return "registform";
	}
	
	@RequestMapping("/registres.do")
	public String registRes(MemberDto dto) {
		
		// 비밀번호 암호화
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		logger.info("암호화 된 memberpw : "+dto.getMemberpw());
		
		if(biz.insert(dto)>0) {
			return "redirect:loginform.do";
		}
		
		return "redirect:regitsform.do";
	}
}
