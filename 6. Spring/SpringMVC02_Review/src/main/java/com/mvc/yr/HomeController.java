package com.mvc.yr;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.yr.model.dto.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.go", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/command.go", method=RequestMethod.GET)
	public String getCommand(Model model, @ModelAttribute Student st) {
		
		Student s2 = new Student("이제훈",1,"한국예술대");
		Student s3 = new Student("서강준",2,"동서울대");
		List<Student> list = new ArrayList<Student>();
		list.add(st);
		list.add(s2);
		list.add(s3);
		
		model.addAttribute("list",list);
		
		return "getcmd";
	}
	
	@RequestMapping(value="/command.go",method=RequestMethod.POST)
	public String postCommand(Model model, String name, int grade, @RequestParam("schoolName")String className) {
		
		model.addAttribute("student",new Student(name, grade, className));
		
		return"postcmd";
	}
	
}
