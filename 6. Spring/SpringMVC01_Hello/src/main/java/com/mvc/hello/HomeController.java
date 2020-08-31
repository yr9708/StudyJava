package com.mvc.hello;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // get방식에서만 호출해요 라고 써준거, 둘다 동작하고싶음ㄴ 둘다 생략하거나 둘다써주거나
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		/*
		 * request.setCharacterEncoding("utf-8");
		 * response.setContentType("text/html; charset=utf-8");
		 */
		
		logger.info("Welcome home! The client locale is {}.", locale); // ★ sysout대신에 logger 써주는 것.
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // servlet-context.xml에 있는 ViewResolver에 시작:"/WEB-INF/views/" 끝:.jsp 라고 저장이 되어있다.
	}
	
}
