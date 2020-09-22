package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication // Web.xml이라고 생각해주면 된다.
@Controller
public class StartBoot01Application {

	public static void main(String[] args) { // 프로그램의 주 진입점
		SpringApplication.run(StartBoot01Application.class, args);
	}

	@GetMapping("/index") // RequestMapping과 비슷한데 대신에 Get으로 보내면 GetMapping, Post로 보내면 PostMapping 
	public String index() {
		System.out.println("!");
		return "index";
	}
}
