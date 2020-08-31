package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.biz.HelloBiz;

@Controller
public class HelloController {
	
	// TODO : 05. biz(@Service) 호출
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04. handler mapping("/hello.do") 통해 controller의 메소드를 찾아온다.
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// TODO : 09. return 받은 값을 model 객체에 담아서 전달 (ModelAndView)
		model.addAttribute("message",biz.getHello());
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	// ("name") 이름과 String name 이렇게 변수명이 같으면 @RequestParam("name") 생략 가능
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String nickname) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message","Bye, "+nickname);
		
		return mav;
	}
}

/*

@RequestMapping
 - url을 class 또는 method와 mapping시켜주는 역할
 
@RequestParam
 - key = value 형태로 넘어오는 queryString(Parameter)을 mapping된 method의 파라미터와 연결 시켜줌
 - 주로get방식을 사용함

@ModelAttribute
 - form tag를 통해 넘어온 model을 mapping된 method의 파라미터와 연결
 - 주로post방식을 사용함

@SessionAttribute
 - session 객체에 model 정보를 유지하고 싶을 경우 사용
 




 */