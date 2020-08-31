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
	
	// TODO : 05. biz(@Service) ȣ��
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04. handler mapping("/hello.do") ���� controller�� �޼ҵ带 ã�ƿ´�.
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// TODO : 09. return ���� ���� model ��ü�� ��Ƽ� ���� (ModelAndView)
		model.addAttribute("message",biz.getHello());
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	// ("name") �̸��� String name �̷��� �������� ������ @RequestParam("name") ���� ����
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
 - url�� class �Ǵ� method�� mapping�����ִ� ����
 
@RequestParam
 - key = value ���·� �Ѿ���� queryString(Parameter)�� mapping�� method�� �Ķ���Ϳ� ���� ������
 - �ַ�get����� �����

@ModelAttribute
 - form tag�� ���� �Ѿ�� model�� mapping�� method�� �Ķ���Ϳ� ����
 - �ַ�post����� �����

@SessionAttribute
 - session ��ü�� model ������ �����ϰ� ���� ��� ���
 




 */