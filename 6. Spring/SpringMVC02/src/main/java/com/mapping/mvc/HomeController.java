package com.mapping.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapping.mvc.model.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr")String address, String phone) {
		
		model.addAttribute("dto",new AddressDto(name, address, phone));
		
		return "getcmd";
	}
	
	@RequestMapping(value="/command.do",method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) { //@ModelAttribute이 생략되어있는거야
		
		model.addAttribute("dto",dto);
		
		return "postcmd";
	}

	@RequestMapping(value="/void.do")
	public void voidPage(Model model) {
		model.addAttribute("msg","void page");
		
		// return 이 String 이면 그 string이 viewName이다 그런데 지금 리턴타입이 void네?
		// 그럼 url 이름(/void.do)을 찾는다
	}
	
}
