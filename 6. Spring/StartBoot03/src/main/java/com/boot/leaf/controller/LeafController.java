package com.boot.leaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.model.dto.LeafDto;

@Controller
public class LeafController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","Yoerim");
		return "hello";
	}
	
	@GetMapping("/util")
	public String uril() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String expression(Model model) {
		model.addAttribute("name","Thymeleaf");
		
		LeafDto dto = new LeafDto("java",1);
		model.addAttribute("dto",dto);
		List<LeafDto> list = new ArrayList<LeafDto>();
		list.add(new LeafDto("DataBase",2));
		list.add(new LeafDto("jsp/servlet",3));
		model.addAttribute("list",list);
		
		return "expression";
	}
	
	@GetMapping("/params")
	public String params(Model model, HttpSession session) {
		model.addAttribute("dto",new LeafDto("Spring",4));
		session.setAttribute("pw", "qlcass");
	
		return "params";
		  // return해서 html(jsp 등)로 가는방식이
	      // 포워드방식이다
	      // redirect:해줘야지 포워드를 안한다.
	      // 근데 index에서 넘겨준 id=test방식이 리퀘스트 파라미터 방식인데
	      // 원래는 여기까지만 그 값이 유효가 되는데
	      // 여기서 포워드 방식으로 넘어갔기때문에
	      // params.html에서도 index.html에서 넘겨준 파라미터값이 유지가돼서
	      // params.html에서도 그 값을 쓸 수 있다.
	      // springboot_forward 사진 확인 저 질문이 정확한 답이라고함
	}
	
	@GetMapping("/static")
	public String staticTest() {
		return "static";
	}
}
