package com.mvc.upgrade.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz memberBiz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("[loginform.do]");
		return "mvclogin";
	}
	/*
	 * @ResponseBody : java 객체를 response 객체의 데이터로 'binding' 해준다
	 * @RequestBody : request 객체에 담겨져서 넘어오는 데이터 -> java 객체 'binding' (묶어준다)
	 */
	
	@RequestMapping(value="/ajaxlogin.do",method=RequestMethod.POST)
	@ResponseBody 
	public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){ // dispatcherServlet이 알아서 session을 파라미터로 줍니다.
		logger.info("[ajaxlogin.do]");
		/*
		 * ResponseBody : ajax할때만 사용한다. json형식으로 리턴된다
		 * 
		 * ajax로 통해서 왔기 때문에 새로운 페이지로 가면 안된다 (return "페이지이름") ,
			-> viewResolver 안통하고 몰래 왔다 가려고 하는거다.
		 *  원래는 ModelAndView를 리턴해야하는데 보면 자바객체(여기선 map,(웬만하면 json형태로!))을 response 될거야
		 *  response에다가 저 자바객체를 담아서 리턴해줄거야
		 *  
		 * mvclogin.jsp 보면 dataType : "json", 라고 되어있는데 
		 * Controller에서 jackson을 통해(jackson(core,mapper)을 dependency에 주입된것) map을 json 형태로 바꿔서 response객체에 담아 응답시켜준다.
		 * -> jackson이 알아서 json 형태로 바꿔준다.
		 */
		
		
		MemberDto res = memberBiz.login(dto);
		boolean check = false; 
		
		if(res != null) {
			session.setAttribute("login", res); // 만약 로그인이 제대로 됐다면 check를 true 로 바꾸자
			check = true;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
}
