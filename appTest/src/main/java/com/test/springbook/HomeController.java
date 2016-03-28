package com.test.springbook;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twogather.dao.UserDao;
import com.twogather.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class HomeController extends GenericController<Member,Integer>{
	
	@Autowired
	private ApplicationContext context;
	
	
	
	
	@RequestMapping("/main")
	public String board(){
		
		return "board";
	}
	
	@RequestMapping(value="/boardPro")
	public ModelAndView selectBoard(@RequestParam("mNum") int mNum) throws SQLException{
		UserDao dao= context.getBean("userDao",UserDao.class);
		Member member=new Member();
		member=dao.getMember(mNum);
		
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("getMember",member);
		mv.setViewName("myboard");
		return mv;
	}
	
	

	
	/*	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	*//**
	 * Simply selects the home view to render by returning its name.
	 *//*
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	*/
	@RequestMapping(value="/hello")
	public String test(){
		return "hellospring";
	}

	
}
